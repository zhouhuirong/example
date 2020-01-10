package ioc;

import ioc.pojo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception{

        BeanDefind beanObj = new BeanDefind();
        beanObj.setBeanId("student1");
        beanObj.setClassPath("ioc.pojo.Student");
        Map<String,Object> propertyMap = beanObj.getPropertyMap();
        propertyMap.put("name","小明");
        propertyMap.put("age",18);
        propertyMap.put("teacher","teacher2");

        BeanDefind teacher = new BeanDefind();
        teacher.setBeanId("teacher");
        teacher.setClassPath("ioc.pojo.Teacher");
        Map<String, Object> propertyMap1 = teacher.getPropertyMap();
        propertyMap1.put("name","湖南");

        BeanDefind teacher2 = new BeanDefind();
        teacher.setBeanId("teacher2");
        teacher.setClassPath("ioc.pojo.Teacher");
        Map<String, Object> propertyMap2 = teacher.getPropertyMap();
        propertyMap1.put("name","江西");

        List<BeanDefind> beanDefinds = new ArrayList<>();
        beanDefinds.add(beanObj);
        beanDefinds.add(teacher);
        beanDefinds.add(teacher2);
        BeanFactory factory = new BeanFactory();
        factory.setBeanDefinds(beanDefinds);

        Student student = (Student)factory.getBean("student1");
        System.out.println(student);

    }
}
