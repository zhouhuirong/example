package group;

import group.utils.Data;
import group.vo.CateProduct;
import org.junit.Test;
import tree.BillData;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Group {

    public static void main(String[] args) {
        List<CateProduct> data = Data.createData(10);
        Map<String, List<CateProduct>> collect = data.stream().collect(groupingBy(e -> fetchGroupKey(e)));
        for ( Map.Entry<String,List<CateProduct>> c:collect.entrySet()) {
            System.out.println(c.getKey()+"==="+c.getValue());
            List<CateProduct> value = c.getValue();
//            System.out.println(value.get(0));
        }

    }




    private static  String fetchGroupKey(CateProduct data){
        return data.getCateParentId();
    }
}
