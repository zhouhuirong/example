package solr.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    public static Connection getConnection(){
        Connection conne = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             conne = DriverManager.getConnection("jdbc:mysql://106.75.140.232:3306/clound-shop-test-db?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8",
                    "root", "2017*Ecfls*user%2017$");
        } catch (Exception e){

        }
        return conne;
    }
}
