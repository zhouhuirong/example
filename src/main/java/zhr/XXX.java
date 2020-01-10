package zhr;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class XXX {
    private static Properties properties;
    @Test
    public void test() {
        String s = getProperty("om_post");
        System.out.println(s);
        save("sss");
        System.out.println(getProperty("bd_psndoc"));
    }
    public static String getProperty(String key) {
        return getProperty(key, null);
    }
//    public static void setProperty(String key,String value) {
//        properties = getProperties();
//        properties.setProperty(key, value);
//    }

    public static String getProperty(String key, String defaultValue) {
        properties = getProperties();
        return properties.getProperty(key, defaultValue);
    }

    private static  Properties getProperties() {
        Properties props = new Properties();
        String fsp = System.getProperty("file.separator");
        String path = "D:/workEclipse/zhuozhi/zhr/src/main/resources/sx";
        path = path.replace("/", fsp).replace("\\", fsp);
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            props.load(is);
        } catch (IOException ex) {

        }finally{
            if(is!=null){
                try {
                    is.close();
                } catch (IOException ex) {

                }
            }
        }
        return props;
    }

    private static  void save(String value){

        try {
            String fsp = System.getProperty("file.separator");
            String path = "D:/workEclipse/zhuozhi/zhr/src/main/resources/sx";
            path = path.replace("/", fsp).replace("\\", fsp);
            FileOutputStream fos = new FileOutputStream(path);
//            InputStream in = new BufferedInputStream(new FileInputStream(path));
            Properties propertie = getProperties();
//            properties.load(in);
            propertie.put("bd_psndoc","sssxx");
            propertie.store(fos,null);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
