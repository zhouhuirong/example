package categoryTree;

import categoryTree.common.CreatData;
import categoryTree.common.HandleTree;
import categoryTree.pojo.Category;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Category> categories = CreatData.create();
        List<Category> tree = HandleTree.createTree(categories);
        List<Category> childList = HandleTree.getChildList(categories.get(0));
        List<Category> juniors = HandleTree.getJuniors(categories.get(0));
        System.out.println(tree);


    }
}
