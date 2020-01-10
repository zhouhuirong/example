package zhr;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMM {
    private static Document document;

    @Test
    public void test() {
        String xtime = getValue("om_post");
        System.out.println(xtime);
        setValue("bd_psndoc","1988-01-01 01:00:00");
    }
    private static Document getDocument(){
        Document doc = null;
        SAXReader reader = new SAXReader();
        try {
            String fsp = System.getProperty("file.separator");
            String path = "D:/workEclipse/zhuozhi/zhr/src/main/resources/tiem.xml";
            path = path.replace("/", fsp).replace("\\", fsp);
            doc = reader.read(new File(path));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return doc;
    }
//    private static String getPath(){
//        String fsp = System.getProperty("file.separator");
//        String path = RuntimeEnv.getInstance().getNCHome()
//                + "/modules/webservice/META-INF/checktime.xml";
//        path = path.replace("/", fsp).replace("\\", fsp);
//        return path;
//    }
    public static String getValue(String id){
        String s = null;
        Element root = getDocument().getRootElement();
        List<Element> elements = root.elements();
        for (Element element:elements) {
            if (id.equals(element.attributeValue("id"))){
                Element date = element.element("date");
                s = date.getText();
            }
        }
//        Element nameElement = (Element) document.selectSingleNode("/checktime/table[@id='"+id+"']");
        return s;
    }

    public static void setValue(String id,String value){
        document = getDocument();
        Element root = document.getRootElement();
        List<Element> elements = root.elements();
        for (Element element:elements) {
            if (id.equals(element.attributeValue("id"))){
                Element date = element.element("date");
                date.setText(value);
//                element.addAttribute("date",value);
            }
        }
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = null;
        try {
            String fsp = System.getProperty("file.separator");
            String path = "D:/workEclipse/zhuozhi/zhr/src/main/resources/tiem.xml";
            path = path.replace("/", fsp).replace("\\", fsp);
            writer = new XMLWriter(new FileWriter(new File(path)),format);
            writer.write(document);

        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }finally{
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
