package json;

import com.google.gson.JsonArray;

import java.util.List;
import java.util.Map;

public class Person implements Comparable<Person> {

	private String name;
	private Integer age;
	private String  email;
	private JsonArray ncdata;
	private List<Adds> adds;
	private Map<String, JsonArray> map;
	public List<Adds> getAdds() {
		return adds;
	}

	public void setAdds(List<Adds> adds) {
		this.adds = adds;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, Integer age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, JsonArray> getMap() {
		return map;
	}

	public void setMap(Map<String, JsonArray> map) {
		this.map = map;
	}

	public JsonArray getNcdata() {
		return ncdata;
	}

	public void setNcdata(JsonArray ncdata) {
		this.ncdata = ncdata;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", email=" + email + ", adds=" + adds + "]";
	}

	@Override
	public int compareTo(Person o) {
		
		return o.getAge()-this.getAge();
	}

    public static void printlnValur(String name){
		System.out.println("this is" + name);
	}
	
	
}
