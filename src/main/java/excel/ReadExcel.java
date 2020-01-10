package excel;

import com.alibaba.excel.metadata.Sheet;
import com.github.liuhuagui.gridexcel.GridExcel;
import com.github.liuhuagui.gridexcel.util.ExcelType;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ReadExcel {
    @Test
    public void readXlsxByEventModelWithoutEntity() throws Exception {
        InputStream resourceAsStream = new FileInputStream("2007.xlsx");
        GridExcel.readByEventModel(resourceAsStream, Map.class,ExcelType.XLSX)
                .window(1,ts -> System.out.println(new Gson().toJson(ts)))//推荐在这里执行自己的业务逻辑
                .process(cs ->{
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("姓名",cs.get(0));
                    map.put("年龄",cs.get(1));
                    map.put("地址",cs.get(2));
                    return map;
                },0);
    }
    @Test
    public void test(){
        String filePath = "F:/excel/test.xlsx";
        Sheet sheet = new Sheet(1,1);
        List<Object> objects = ExcelUtil.readLessThan1000RowBySheet(filePath,sheet);
//        objects.forEach(System.out::println);
        objects.stream().forEach(e -> {
            Student student = new Student();
            List o = (ArrayList)e;
            setData(student,o);
            System.out.println(student);
        });
    }
    public void setData(Object o, List data){
        Field[] fields = o.getClass().getDeclaredFields();
        for (int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            try {
                fields[i].set(o,data.get(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void test1(){
        String filePath = "F:/excel/test1.xlsx";
        Sheet sheet = new Sheet(1,1);
        List<Object> objects = ExcelUtil.readLessThan1000RowBySheet(filePath,sheet);
        objects.forEach(System.out::println);
        Sheet sheet1 = new Sheet(2,1);
        List<Object> objects1 = ExcelUtil.readLessThan1000RowBySheet(filePath,sheet1);
        objects1.forEach(System.out::println);
    }
}
