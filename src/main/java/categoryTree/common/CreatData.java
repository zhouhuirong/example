package categoryTree.common;

import categoryTree.pojo.Category;

import java.util.ArrayList;
import java.util.List;

public class CreatData {
    public static List<Category> create(){
        Category c1 = new Category(1,"衣服",true,0,true,"admin");
        Category c2 = new Category(2,"鞋子",true,0,true,"admin");
        Category c3 = new Category(3,"外套",true,1,false,"admin");
        Category c4 = new Category(4,"运动鞋",true,2,false,"admin");
        Category c5 = new Category(5,"内衣",true,1,false,"admin");
        Category c6 = new Category(6,"潮流男装外套A",true,3,false,"admin");
        Category c7 = new Category(7,"潮流男装外套B",true,3,false,"admin");
        Category c8 = new Category(8,"睡衣S",true,5,false,"admin");
        Category c9 = new Category(9,"睡衣W",true,5,false,"admin");
        Category c10 = new Category(10,"跑步鞋A",true,4,false,"admin");
        List<Category> list = new ArrayList();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);
        list.add(c7);
        list.add(c8);
        list.add(c9);
        list.add(c10);
        return list;
    }
}
