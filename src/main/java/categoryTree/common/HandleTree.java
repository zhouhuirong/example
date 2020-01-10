package categoryTree.common;

import categoryTree.pojo.Category;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandleTree {
    /**
     * 数据组装成树
     * @param categories
     * @return
     */
    public static List<Category> createTree(List<Category> categories){
        List<Category> newList = new ArrayList<>();
        Map<Integer,Category> map = new HashMap<>();
        for (Category category: categories) {
            map.put(category.getId(),category);
        }
        for (Category c: categories) {
            if (c.getTopParent()){
                newList.add(c);
            } else {
                Category category = map.get(c.getParentId());
                if (category == null){
                    continue;
                }
                category.addChild(c);
            }
        }
        return newList;
    }

    /**
     * 获取某节点的子集合
     * @return
     */
    public static List<Category> getChildList(Category category){
        List<Category> children = category.getChildren();
        return children;
    }

    /**
     * 返回当前节点的晚辈集合
     * @param category
     * @return
     */
    public static List<Category> getJuniors(Category category){
        List<Category> juniorList = new ArrayList<>();
        List<Category> children = category.getChildren();
        if (children == null || children.size()<1){
            return juniorList;
        } else {
            for (Category c:children) {
                juniorList.add(c);
                juniorList.addAll(getJuniors(c));
            }
            return juniorList;
        }
    }

 }
