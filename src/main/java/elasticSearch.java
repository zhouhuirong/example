import com.google.gson.Gson;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Setting;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import solr.Test;
import solr.entity.ProductModel;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 失败
 */
public class elasticSearch {

    public static void main(String[] args) throws UnknownHostException {
        Map<String,String> map = new HashMap<>();
        map.put("cluster.name","my-application");
        Settings.Builder put = Settings.builder().put(map).put("client.transport.ignore_cluster_name", true);
        PreBuiltTransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("47.104.146.50"),9200));

        System.out.println(client);
        Test t = new Test();
        Gson gson = new Gson();
        List<ProductModel> productModels = t.GetProducts();
        for (ProductModel p:productModels) {
            String s = gson.toJson(p);
            client.prepareIndex("test","pp",p.getId().toString()).setSource(s, XContentType.JSON).get();
        }

//        System.out.println(response.getSourceAsString());//打印出json数据
        client.close();//关闭客户端
    }
}
