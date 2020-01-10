package zhr;

import com.sun.istack.internal.NotNull;

public class Lambda {
	private String name;
	private Integer age;
	
	public Lambda() {
		super();
	}
	public Lambda(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Lambda [name=" + name + ", age=" + age + "]";
	}
	
	
}
