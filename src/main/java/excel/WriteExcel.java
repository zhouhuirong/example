package excel;

import com.alibaba.excel.metadata.Sheet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WriteExcel {

    /**
     * 导出单sheet表格
     */
    @Test
    public void test(){
        String filePath = "F:/excel/test.xlsx";
        List<TableHeaderExcelProperty> data = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
            tableHeaderExcelProperty.setName("徐" + i);
            tableHeaderExcelProperty.setAge(22 + i);
            tableHeaderExcelProperty.setSchool("清华大学" + i);
            data.add(tableHeaderExcelProperty);
        }

        ExcelUtil.writeWithTemplate(filePath,data);
    }

    /**
     * 导出多sheet表格
     */
    @Test
    public void test1(){
        String filePath = "F:/excel/test1.xlsx";
        ArrayList<ExcelUtil.MultipleSheelPropety> list1 = new ArrayList<>();
        for (int j=1;j<3;j++){
            List<TableHeaderExcelProperty> data = new ArrayList<>();
            for(int i = 0; i < 4; i++){
                TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
                tableHeaderExcelProperty.setName("徐" + i+j);
                tableHeaderExcelProperty.setAge(22 + i+j);
                tableHeaderExcelProperty.setSchool("清华大学" + i+j);
                data.add(tableHeaderExcelProperty);
            }

            Sheet sheet = new Sheet(j,0);
            sheet.setSheetName("班级"+j);

            ExcelUtil.MultipleSheelPropety multipleSheelPropety = new ExcelUtil.MultipleSheelPropety();
            multipleSheelPropety.setData(data);
            multipleSheelPropety.setSheet(sheet);

            list1.add(multipleSheelPropety);
        }
        ExcelUtil.writeWithMultipleSheel(filePath,list1);
    }

}
