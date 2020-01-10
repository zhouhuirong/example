package json;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTO {
//	Gson gson = new Gson();
	Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

	/**
     * java对象转json字符串
     */
	@Test
	public void test1() {
		Person p1 = new Person("周一", 1, "day1");
		Person p2 = new Person("周二", 2, "day2");
		Person p3 = new Person("周三", 3, "day3");
		Person p4 = new Person("周四", 4, "day4");
		Person [] arry = {p1, p2, p3, p4};
		String arryJson = "{"+'"'+"target"+'"'+":"+"100"+","+'"'+"data"+'"'+":"+gson.toJson(arry)+"}";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qq",arryJson);
		// 装换成json
		Gson gson = new Gson();
		String jsonMap = gson.toJson(map);
		System.out.println(arryJson);
		// JsonParser解析json字符串， getAsJsonObject转换为JsonObject对象，JsonObject对象可以获取对象中单独的属性值
		JsonObject asJsonObject = new JsonParser().parse(jsonMap).getAsJsonObject();
		System.out.println(asJsonObject);
		JsonElement decodeContent = asJsonObject.get("qq");

		System.out.println(decodeContent);

//		JsonElement orderCancelJson = decodeContent.get("data");
//		JsonObject asJsonObjectss = new JsonParser().parse(decodeContent.toString()).getAsJsonObject();

		// 获取data属性值，因为data属性值是数组的json字符串所以可以用getAsJsonArray()
//		JsonArray asJsonArray = asJsonObject.get("data").getAsJsonArray();
//		// JsonArray可以遍历单独获取数组中的值然后进行操作
//		for (JsonElement jsonElement : asJsonArray) {
//			Person fromJson = gson.fromJson(jsonElement, Person.class);
//			System.out.println(fromJson.getName());
//		}
//		// JsonArray 直接转换成数组
//		Person[] person = gson.fromJson(asJsonArray, Person[].class);
//		System.out.println(person[0]);
//		// 获取JsonObject 对象中target属性的值（如果是string、int 等基本数据类型可以直接通过 getAs数据类型()  获取）
////		int target = asJsonObject.get("target").getAsInt();
//		String target = new String();
//
//		 target= asJsonObject.get("target").toString();
//		System.out.println("target"+target);
//		String target1 = asJsonObject.get("target").getAsString();
//		System.out.println("target1"+target1);
//
//		JsonElement element = asJsonObject.get("target");
//		Integer targetEle = gson.fromJson(element, Integer.class);
//		System.out.println(targetEle);

	}
	/**
	 * 数组
	 */
	@Test
	public void test2() {
		String[] arr = {"小白","小黑","小小"};
		String json = gson.toJson(arr);
		System.out.println(json);
		String[] p = gson.fromJson(json, String[].class);
		System.out.println(p[0]);
	}
	/**
	 * list
	 */
	@Test
	public void test3() {
		List<String> list = new ArrayList<String>();
		list.add("q");
		list.add("b");
		String json = gson.toJson(list);
		System.out.println(json);
		List<String> p = gson.fromJson(json, (new TypeToken<List<String>>() {}).getType());
		System.out.println(p.get(0));
	}
	@Test
	public void test4() {
		Person person = new Person("ss", 33, "163");
		List<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(6);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("obj", person);
		map.put("list", list);
		String json = gson.toJson(map);
		System.out.println(json);

		JsonObject asJsonObject = new JsonParser().parse(json).getAsJsonObject();
		JsonElement jsonElement = asJsonObject.get("obj");
		Person fromJson = gson.fromJson(jsonElement.toString(), Person.class);
		System.out.println(fromJson.getName());

		JsonElement jsonElement2 = asJsonObject.get("list");
		List<Integer> fromJson2 = gson.fromJson(jsonElement2.toString(), (new TypeToken<List<Integer>>() {}).getType());
		System.out.println(fromJson2.get(0));
	}
	@Test
	public void test5() {
		Person p = new Person("zhangsan", 33, "1999");
		Adds a = new Adds(1, "changchun");
		Adds b = new Adds(2, "南昌");
		List<Adds> adds = new ArrayList<>();
		adds.add(a);
		adds.add(b);
		p.setAdds(adds);
		String jsonp = gson.toJson(p);
		System.out.println(jsonp);

		JsonObject asJsonObject = new JsonParser().parse(jsonp).getAsJsonObject();
		JsonElement jsonElement = asJsonObject.get("adds");
		List<Adds> l  = gson.fromJson(jsonElement.toString(), (new TypeToken<List<Adds>>() {}).getType());
		System.out.println(l.get(0).getMessage());

		Person person = gson.fromJson(asJsonObject, Person.class);
		System.out.println(person);
	}
	@Test
	public void test6() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "goudan");
		Person person = gson.fromJson(jsonObject, Person.class);
		System.out.println(person);
	}
	@Test
	public void test7(){
		Adds a = new Adds();
		a.setId(1);
		a.setMessage("xx");
		Adds b = new Adds();
		b.setId(2);
		b.setMessage("xxb");
		List<Adds> adds = new ArrayList<>();
		adds.add(a);
		adds.add(b);
		String jsonp = gson.toJson(adds);
		System.out.println(jsonp);
		JsonElement parse = new JsonParser().parse(jsonp);
		JsonArray asJsonObject = new JsonParser().parse(jsonp).getAsJsonArray();
		System.out.println(asJsonObject);
		Person p = new Person();
		p.setAge(18);
		p.setName("xx");
//        p.setEmail(jsonp);
        p.setNcdata(asJsonObject);
		String json = gson.toJson(p);
		System.out.println(json);
		JsonObject asJsonObject1 = new JsonParser().parse(json).getAsJsonObject();
		JsonArray ncdata = asJsonObject1.get("ncdata").getAsJsonArray();
		System.out.println(ncdata);
		List<Adds> l  = gson.fromJson(ncdata, (new TypeToken<List<Adds>>() {}).getType());
		System.out.println(l.get(0).getMessage());
	}

    @Test
	public void test8(){
		Object obj = "[{\"psncode\":\"003817\",\"code\":\"1002\"}, {\"psncode\":\"003810\",\"code\":\"1002\"}]";

		System.out.printf(obj.toString());
	}
}
