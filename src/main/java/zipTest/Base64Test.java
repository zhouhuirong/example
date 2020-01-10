package zipTest;




import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

import java.util.UUID;

public class Base64Test {

    private static String uploadPath="F:\\uploadFile";

    /**
     * <p>将base64字符解码保存文件</p>
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */
    public static void decoderBase64File(String base64Code,String targetPath) throws Exception {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
//        System.out.println(new String(buffer));
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

    public static void main(String[] args) throws Exception  {
//        String path = "D:/uploadFile/bug.zip";
//        String str = encodeBase64File(path);
        String str = "UEsDBBQACAAIAANSO08AAAAAAAAAAAAAAAAkAAAAYTAzYzdlNTkwMmU1NGM5MGIyZWI4ZTI1NDhkNmUwZDUuVE1QszczMjIzMzI0MjC3NDC1NDapOXjt+APDGhA0MjC0NLA0MKs5vvLKnhouZJVmlpaWNVd+nP9nhE0lAFBLBwjvVBaeOgAAAFUAAABQSwECFAAUAAgACAADUjtP71QWnjoAAABVAAAAJAAAAAAAAAAAAAAAAAAAAAAAYTAzYzdlNTkwMmU1NGM5MGIyZWI4ZTI1NDhkNmUwZDUuVE1QUEsFBgAAAAABAAEAUgAAAIwAAAAAAA==";
        String str2 ="UEsDBBQACAAIAKpTO08AAAAAAAAAAAAAAAAkAAAANjc1NzJlNzlkNjBiNDFhY2EwMWVkZThkMTQxYzQ1NzQuVE1QhYsxDsAgDMR2XuMjBeWmfiyPbyRGhtqjZa9FJhNC8YCU9V6U2omM2d1r+HyN8Abb9bN8UEsHCMVqHyQzAAAAawAAAFBLAQIUABQACAAIAKpTO0/Fah8kMwAAAGsAAAAkAAAAAAAAAAAAAAAAAAAAAAA2NzU3MmU3OWQ2MGI0MWFjYTAxZWRlOGQxNDFjNDU3NC5UTVBQSwUGAAAAAAEAAQBSAAAAhQAAAAAA";
        decoderBase64File(str, "F:/uploadFile/bug1.zip");
        //String str2 = encodeBase64File("D:/uploadFile/bug4.zip");
        System.out.println(str2);
        decoderBase64File(str2, "F:/uploadFile/bug2.zip");


    }
    /**
     * <p>将文件转成base64 字符串</p>
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }

}
