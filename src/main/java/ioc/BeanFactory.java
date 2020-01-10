package ioc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanFactory {
    private List<BeanDefind> beanDefinds;

    public List<BeanDefind> getBeanDefinds() {
        return beanDefinds;
    }

    public void setBeanDefinds(List<BeanDefind> beanDefinds) {
        this.beanDefinds = beanDefinds;
    }

    /**
     * 依赖注入的方法 控制反转是一种解耦的设计思路，依赖注入是它的一种实现方式。
     * 一个对象依赖另一个对象时，会在已经注入容器中的对象中查找对应的依赖对象然后通过反射实列化对象
     * @param instance 当前的实例对象
     * @param classFile 当前实例对象所关联的类文件
     * @param propertyMap 属性
     */
    public void setValue(Object instance, Class classFile, Map<String,Object> propertyMap)throws Exception{
        if (propertyMap != null &&propertyMap.size()>0){
            Set<String> proper = propertyMap.keySet();
            for (String string:proper) {
                // 通过字符串拼接，拼出set方法名
               char c = string.toUpperCase().charAt(0);
               String s = "set" + c + string.substring(1);
               // 获取当前属性的类型
               Field field = classFile.getDeclaredField(string);
               // 根据属性的类型进行调用
               Method m = instance.getClass().getMethod(s, field.getType());
               try{
                   m.invoke(instance,propertyMap.get(string));
               }catch (Exception e){
                   m.invoke(instance,getBean(propertyMap.get(string).toString()));
               }
            }
        }
    }

    public Object getBean(String beanId)throws  Exception{
        Object instance = null;
        for (BeanDefind bean:beanDefinds) {
            if (beanId.equals(bean.getBeanId())){
                String classPath = bean.getClassPath();
                Class<?> classFile = Class.forName(classPath);
                instance = classFile.newInstance();
                Map<String, Object> propertyMap = bean.getPropertyMap();
                setValue(instance,classFile,propertyMap);
                return instance;
            }
        }
        return null;
    }
}
