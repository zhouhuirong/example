package solr.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class CateProductModel implements Serializable {
    /**导航分类id*/
    private Long cateId;
    /**商品id*/
    private Long productId;
    /**分类名称*/
    private String cateName;
    /**主分类名称*/
    private String cateParentName;
    /**主分类id*/
    private Long cateParentId;
    /**分类路径*/
    private String cateIdPath;
    /**商品是否关联 1 是 0 否*/
    private boolean deleted;

}
