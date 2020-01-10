package group.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CateProduct {
    private String cateId;
    private String productId;
    private String cateParentId;
    private String cateParentName;
    private String productName;

}
