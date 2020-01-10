package zipTest;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadZip {
    public static void read(String  path) throws IOException {
        //获取文件输入流 "C:\\Users\\Administrator\\Desktop\\test\\test.zip"
        FileInputStream input = new FileInputStream(path);

        //获取ZIP输入流(一定要指定字符集Charset.forName("GBK")否则会报java.lang.IllegalArgumentException: MALFORMED)
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(input), Charset.forName("GBK"));

        //定义ZipEntry置为null,避免由于重复调用zipInputStream.getNextEntry造成的不必要的问题
        ZipEntry ze = null;

        //循环遍历
        while ((ze = zipInputStream.getNextEntry()) != null) {

            System.out.println("文件名：" + ze.getName() + " 文件大小：" + ze.getSize() + " bytes");
            System.out.println("文件内容：");

            //读取
            BufferedReader br = new BufferedReader(new InputStreamReader(zipInputStream,Charset.forName("GBK")));


            String line = null;

            //内容不为空，输出
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        //一定记得关闭流
        zipInputStream.closeEntry();
        input.close();

    }

    public static void main(String[] args) throws IOException {
//        read("F:\\zip\\CompressFile\\AAAtest.zip");
        read("F:\\uploadFile\\bug1.zip");
    }
}
