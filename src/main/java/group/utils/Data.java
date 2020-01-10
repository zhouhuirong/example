package group.utils;

import group.vo.CateProduct;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<CateProduct> createData(int i){
        List<CateProduct> list = new ArrayList<>();
        int count = 0;
        while (count<i){
            CateProduct c = new CateProduct();
            c.setCateId("分类id"+count);
            c.setCateParentId((count%3==0?1:2)+"");
            c.setProductId("商品id"+count);
            c.setCateParentName("系列"+(count%3==0?1:2));
            c.setProductName("商品名称"+count);
            list.add(c);
            count++;
        }
        return list;
    }
}
