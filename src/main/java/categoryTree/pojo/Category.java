package categoryTree.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Category {
    //分类id
    private Integer id;
    //分类名称
    private String name;
    //状态 1正常 0删除
    private Boolean status;
    //父类id
    private Integer parentId;
    //是否父类 1是 0否
    private Boolean topParent;
    //创建者
    private String creater;

    private List<Category> children;

    public Category() {
    }

    public Category(Integer id, String name, Boolean status, Integer parentId, Boolean topParent, String creater) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.parentId = parentId;
        this.topParent = topParent;
        this.creater = creater;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", parentId=" + parentId +
                ", topParent=" + topParent +
                ", creater='" + creater + '\'' +
                ", children=" + children +
                '}';
    }

    /**
     * 添加子节点
     * @param chi
     */
    public void addChild(Category chi){
        if (this.children == null){
            this.children = new ArrayList<Category>();
        }
        this.children.add(chi);
    }


}
