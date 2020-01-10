package ioc;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class BeanDefind {
    // bean的id
    private String beanId;
    //bean的文件路径
    private String classPath;
    //对象的属性值的集合
    private Map<String,Object> propertyMap = new HashMap<>();

}
