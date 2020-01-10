package solr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import solr.entity.CateProductModel;
import solr.entity.ProductModel;
import solr.utils.ConnectionUtil;
import solr.utils.ToDocument;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * solr搭建
 * 1、在tomcat中放入solr服务
 * 2、在schema.xml文件中配置Field,需要添加的字段都需要对应一个Field
 * 3、通过Java代码把MySQL数据同步到文档库也可以在配置文件中配置好通过solr管理页面同步
 * 4、Java代码中向文档库添加文档是根据id进行修改的。有的数据做修改，没有的数据做新增，删除需要根据查询条件删除
 *
 */
public class Test {
    static   HttpSolrServer  server = new HttpSolrServer("http://localhost:2121/solr/core-product");

    public static void main(String[] args) throws IOException, SolrServerException {

        List<ProductModel> productModels = GetProducts();
        List<SolrInputDocument> documents = getDocuments(productModels);
        LocalDateTime timeStart = LocalDateTime.now();
        add(documents);
//        deleted(564600L);

        LocalDateTime timeEnd= LocalDateTime.now();
        System.out.println(Duration.between(timeStart,timeEnd).toMillis());

    }


    public static void query(){
        /**
         * 1、精准搜索
         *    如果点击主分类传入分类id 比如蓝臻系列分类id是 4
         *    如果点击子分类传入主分类和子分类id 比如蓝臻系列 1-2个月 是 4,6 注意要用英文逗号连接
         * 2、模糊搜索
         *    传入关键词
         *    查询语句
         *      name:*蓝臻系列* OR
         *      cateName_c:*蓝臻系列* OR
         *      cateParentName_c:*蓝臻系列* OR
         * 3、排序
         *    传入需要排序的字段和排序方式
         *
         *
         *
         */
    }
    // 新增或修改文档库
    public static void add(List<SolrInputDocument> documents) throws IOException, SolrServerException {
        server.add(documents);
        server.commit();
    }
    // 删除文档
    public static void deleted(Long id) throws IOException, SolrServerException {
        server.deleteByQuery("id:"+id);
        server.commit();
    }


    public static List<SolrInputDocument> getDocuments(List<ProductModel> products){
        List<SolrInputDocument> documents = new ArrayList<>();
        for (ProductModel item:products) {
            SolrInputDocument document = ToDocument.toSolrInputDocument(item);
            documents.add(document);
        }
        return documents;
    }


    public static List<ProductModel> GetProducts(){
        List<ProductModel> products = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT \n" +
                "  id,\n" +
                "\talias_name AS aliasName,\n" +
                "\tcheck_status AS checkStatus,\n" +
                "\tdeleted,\n" +
                "\timage_url AS imageUrl,\n" +
                "\tname,\n" +
                "\toriginal_price AS originalPrice,\n" +
                "\tprice,\n" +
                "\tbrand_id AS brandId,\n" +
                "\tbrand_name AS brandName,\n" +
                "\ttype_id AS typeId,\n" +
                "\ttype_name AS typeName,\n" +
                "\ttype_idpath AS typeIdpath,\n" +
                "\tdeclare_plan AS declarePlan,\n" +
                "\tcoin_flag AS coinFlag,\n" +
                "\tcoin_per AS coinPer,\n" +
                "\tself_support AS selfSupport,\n" +
                "\tsales_volume AS salesVolume,\n" +
                "\tpf_channel AS pfChannel,\n" +
                "\tshow_title AS showTitle,\n" +
                "\tdown_sate AS downSate\n" +
                "FROM\n" +
                "\tproduct\n" +
                "WHERE\n" +
                "\tdeleted = 0\n" +
                "AND down_sate = 1;";
        ResultSet rs = null;
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            ProductModel p =null;
            while (rs.next()){
                p = new ProductModel();
                p.setId(rs.getLong("id"));
                p.setAliasName(rs.getString("aliasName"));
                p.setCheckStatus(rs.getString("checkStatus"));
                p.setDeleted(rs.getBoolean("deleted"));
                p.setImageUrl(rs.getString("imageUrl"));
                p.setName(rs.getString("name"));
                p.setOriginalPrice(rs.getDouble("originalPrice"));
                p.setPrice(rs.getDouble("price"));
                p.setBrandId(rs.getLong("brandId"));
                p.setBrandName(rs.getString("brandName"));
                p.setTypeId(rs.getLong("typeId"));
                p.setTypeName(rs.getString("typeName"));
                p.setTypeIdpath(rs.getString("typeIdpath"));
                p.setDeclarePlan(rs.getString("declarePlan"));
                p.setCoinFlag(rs.getBoolean("coinFlag"));
                p.setCoinPer(rs.getInt("coinPer"));
                p.setSelfSupport(rs.getBoolean("selfSupport"));
                p.setSalesVolume(rs.getInt("salesVolume"));
                p.setPfChannel(rs.getLong("pfChannel"));
                p.setShowTitle(rs.getString("showTitle"));
                p.setDownSate(rs.getInt("downSate"));
                products.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != rs){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null!=ps){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        return products;
    }
}
