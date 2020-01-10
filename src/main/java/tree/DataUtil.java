package tree;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    public static List<BillData> getData(int i){
        List<BillData> datas = new ArrayList<>();
        for (int j = 1; j < i ; j++) {
            BillData data = new BillData("组织编码10"+j%3,"客商编码20"+j%2,"来源系统编码30"+j%3,""+j%2, ""+j);
            datas.add(data);
        }
        return datas;
    }
}
