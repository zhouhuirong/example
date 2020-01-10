package zhr;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipOutputStream;

/**
 * 
 * @author zhr
 *
 */
public class Test {

    @org.junit.Test
	public void date() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date parse = sdf.parse("2019-06-18 15:52:33");
		System.out.println(parse);
	}
	@org.junit.Test
	public  void  test(){
		Lambda l = new Lambda();
		l.setAge(1);
		l.setName("yi");
		Lambda ll = new Lambda();
		ll.setAge(1);
		ll.setName("yi");
		List<Lambda> list = new ArrayList<Lambda>();
		list.add(l);
		list.add(ll);
		Map<String,List<Lambda>> map = new HashMap<String, List<Lambda>>();
		map.put("xx",list);
		map.put("ss",list);
		Gson gson = new Gson();
		String toJson = gson.toJson(map);
		JsonElement parse = new JsonParser().parse(gson.toJson(map));
		String s = gson.toJson(toJson);
		String sp = gson.toJson(parse);
		System.out.println(toJson);
		System.out.println(parse);
		System.out.println(s);
		System.out.println(sp);
	}
	@org.junit.Test
	public void test1(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("psncode","sdx");
        String psncode = new String();
        psncode = map.get("psnc") != null ? (String)map.get("psnc") : "1";
        System.out.println(psncode);
    }
    @org.junit.Test
    public void test4(){
    	if (1==11){
			System.out.println(1);
		} else if (2==3){
			System.out.println(2);
		}else if (3==3){
			System.out.println(3);
		}else {
			System.out.println("sss");
		}
	}
	@org.junit.Test
	public void test5(){
		try {
			String str = "hahahh";
		    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("F:\\test.zip"));

		    zipOutputStream.write(str.getBytes());
//			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("F:\\test.txt"),
//					"UTF-8");
//			osw.write("你好");
//			osw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
