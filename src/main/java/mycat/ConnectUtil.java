package mycat;

import java.sql.*;

public class ConnectUtil {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conne = DriverManager.getConnection("jdbc:mysql://192.168.30.107:8066/zhouhr?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8",
                "root", "123456");
//        Connection conne = DriverManager.getConnection("jdbc:mysql://192.168.30.107:3306/zhr?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8",
//                "root", "zhr123");
        System.out.println(conne);
        Statement statement = conne.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user;");
        int id;
        String name;
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            name = resultSet.getString("name");

            System.out.println(name+'\t'+id);
        }
        resultSet.close();
        conne.close();
    }
}
