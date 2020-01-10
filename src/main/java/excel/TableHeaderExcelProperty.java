package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 定义数据模型对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TableHeaderExcelProperty extends BaseRowModel {

    /**
     * value：表头名称
     * index：列的号，从0开始
     *
     */

    @ExcelProperty(value = "姓名", index = 0)
    private String name;
    @ExcelProperty(value = "年龄", index = 1)
    private Integer age;
    @ExcelProperty(value = "学校", index = 2)
    private String school;
}
