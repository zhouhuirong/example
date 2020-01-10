package reflect;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class NoteFilter {
    public static String valid(Object obj){
        StringBuilder message = new StringBuilder();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            NotNull notNull = field.getAnnotation(NotNull.class); // 获取有NotNull注解的属性
            if(notNull != null){
                field.setAccessible(true);
                try {
                    Object o = field.get(obj);
//                    StringUtils.isBlank((String)field.get(obj));
                    if (null == o || StringUtils.isBlank(o.toString())){
                       message.append(notNull.message()).append("; ");
                   }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return message.toString();
    }
}
