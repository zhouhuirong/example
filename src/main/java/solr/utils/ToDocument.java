package solr.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.common.SolrInputDocument;
import solr.entity.CateProductModel;
import solr.entity.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToDocument {
    private  static  Connection connection = ConnectionUtil.getConnection();
    // 数据转换成solr文档，文档类似mongoDB中的json数据可以添加自定义字段
    public static SolrInputDocument toSolrInputDocument(ProductModel product){
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", product.getId());
        document.addField("name", product.getName());
//        document.addField("aliasName", product.getAliasName());
//        document.addField("itemCode",product.getItemCode());
        document.addField("imageUrl", product.getImageUrl());
        document.addField("price", product.getPrice());
        document.addField("originalPrice", product.getOriginalPrice());
        document.addField("brandId_l", product.getBrandId());
        document.addField("brandName_s", product.getBrandName());
        document.addField("typeName_s", product.getTypeName());
        document.addField("typeIdPath_s", product.getTypeIdpath());
        //如果排序值默认为空，则给999999999
        Integer orderValue = product.getOrderValue();
        document.addField("orderValue_i", orderValue != null ? orderValue : 999999999);
        //        document.addField("orderValue_i", product.getOrderValue());
        document.addField("coinFlag_b", product.getCoinFlag());
        document.addField("coinPer_i", product.getCoinPer());
        document.addField("selfSupport_b", product.getSelfSupport());
        document.addField("deleted_b", product.isDeleted());
        document.addField("pfChannel_l", product.getPfChannel());
        document.addField("salesVolume_i", product.getSalesVolume()+product.getBuyNum());
        document.addField("declarePlan_s", product.getDeclarePlan());
        document.addField("showTitle_s", product.getShowTitle());
        /**
         * 同步索引
         * 在索引库添加三个索引,全部采用<field name="cateIdPath_c" type="string" indexed="true" stored="true"/>
         *   用于精准搜索
         *    cateIdPath_c 分类id路径 ,4,6,
         *   用于模糊搜索
         *    cateName_c 分类名称  ,0-6个月,
         *    cateParentName_c 所属主分类 ,蓝臻系列,
         *    如果一件商品有多个分类        所属分类一   分类二
         *      cateIdPath_c 分类id路径          ,4,6,8,9,
         *      cateName_c 分类名称            ,0-6个月,2岁以上,
         *      cateParentName_c 所属主分类    ,蓝臻系列,铂臻系列,
         */
        Long productId = product.getId();
        List<CateProductModel> cateProducts = getCateProducts(productId);
        StringBuilder cateIdPath =new StringBuilder("");
        StringBuilder cateName=new StringBuilder("");
        StringBuilder cateParentName=new StringBuilder("");
        // 判断商品是否取消关联，如果取消关联索引会定义为null,索引库这个字段就没有
        for (CateProductModel cateProduct:cateProducts) {
            if (!cateProduct.isDeleted()){
                cateIdPath.append(cateProduct.getCateIdPath());
                cateName.append(",").append(getName(cateProduct.getCateId())).append(",");
                String parentName = getName(cateProduct.getCateParentId());
                cateParentName.append(",").append(StringUtils.isBlank(parentName)?"":parentName).append(",");
            }

        }

        document.addField("cateIdPath_c",StringUtils.isBlank(cateIdPath.toString())? null:cateIdPath.toString());
        document.addField("cateName_c",StringUtils.isBlank(cateName.toString())?null:cateName.toString());
        document.addField("cateParentName_c",StringUtils.isBlank(cateParentName.toString())?null:cateParentName.toString());
        return document;
    }

    public static String getName(Long id){
//        Connection connection = ConnectionUtil.getConnection();
        String sql = "select name from crm_category where id ="+id+";";
        ResultSet rs = null;
        PreparedStatement ps=null;
        String name = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            if (null != rs){
////                try {
////                    rs.close();
////                } catch (SQLException e) {
////                    e.printStackTrace();
////                }
////            }
////            if (null!=ps){
////                try {
////                    ps.close();
////                } catch (SQLException e) {
////                    e.printStackTrace();
////                }
////            }
        }
        return name;

    }

    public static List<CateProductModel> getCateProducts(Long productId){
        List<CateProductModel> cateProducts = new ArrayList<>();
//        Connection connection = ConnectionUtil.getConnection();
        String sql = "select c.parent_id as parentId,cp.cate_id as cateId, cp.product_id as productId,cp.deleted,\n" +
                "CONCAT(',',c.parent_id,',',c.id,',') as cateIdPath from crm_category c\n" +
                "inner join crm_cate_product cp on c.id = cp.cate_id\n" +
                "where c.`status`=1 and cp.product_id ="+productId+";";
        ResultSet rs = null;
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            CateProductModel c = null;
            while (rs.next()){
                c = new  CateProductModel();
                c.setCateParentId(rs.getLong("parentId"));
                c.setCateId(rs.getLong("cateId"));
                c.setProductId(rs.getLong("productId"));
                c.setDeleted(rs.getBoolean("deleted"));
                c.setCateIdPath(rs.getString("cateIdPath"));
                cateProducts.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            if (null != rs){
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (null!=ps){
//                try {
//                    ps.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        return cateProducts;
    }
}
