package zhr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Lambda l = new Lambda("zhaosi", 18);
		JsonObject jsonObject = new JsonObject();
	    jsonObject.addProperty("name", "zhangsan");
	    JsonObject jsonObject1 = new JsonObject();
	    jsonObject1.addProperty("name", "lisi");
	    jsonObject.add("p", jsonObject1);
	    System.out.println(jsonObject);
	    Gson gson = new Gson();
	    Lambda lambda = gson.fromJson(jsonObject1, Lambda.class);
	    System.out.println(lambda);
	    String json = gson.toJson(l);
	    System.out.println(json);
	    Gson gson1 = new GsonBuilder().enableComplexMapKeySerialization().create();
	    String json2 = gson1.toJson(l);
	    System.out.println(json2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate = df.format(new Date());
		System.out.println(nowDate);
	}
}
