package ioc.pojo;

import lombok.Data;

@Data
public class Student {
    private String name;
    private Integer age;
    private Teacher teacher;
}
