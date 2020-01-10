package lambda;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

import json.Person;

public class LambdaTest {
	public static boolean status = true;
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
	    int i = 0;
		list.forEach(o -> {
		  if(o>5) {
			  status = false;
		  }
		});
		System.out.println(status);
		for (Integer integer : list) {
			if(integer>2) {
				i = 10;
				return;
			}
		}
		System.out.println(i);
	}
	@Test
	public void test() {
		Integer [] integers  = {1,2,3,1,2,7,35,6,9,7};
		List<Integer> number = Arrays.asList(integers);
		List<Integer> list = number.stream().map(i -> i).distinct().collect(Collectors.toList());
		System.out.println(list);
	}
	@Test
	public void date() {

		LocalDate local = LocalDate.now();
        LocalDate localDate = local.minusDays(1L);
        System.out.println(localDate);
		int dayOfMonth = LocalDate.now().getDayOfMonth();

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format = ofPattern.format(now);
		System.out.println(format);
	}
	@Test
	public void compare() {
		List<Integer> a = Arrays.asList(1,2,3,4,5);
		Person p1 = new Person("a", 1, null);
		Person p2 = new Person("b", 2, null);
		Person p3 = new Person("c", 3, null);
		Person p4 = new Person("d", 4, null);
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.stream().forEach(p->System.out.println(p));
	}
	@Test
	public void colon(){
		Person p = new Person();
		List<String> list = new ArrayList<>();
		list.add("周一");
		list.add("周二");
		list.add("周三");
		BiConsumer<Person, String> setName = Person::setName;
		list.forEach(x -> setName.accept(p,x));
		System.out.println(p);
		list.forEach(Person :: printlnValur);
	}
	private static final Map<String,String> context = new HashMap<String, String>(){{
		this.put("姓","赵");
		this.put("名","赵");
	}};
	@Test
	public void map(){
		context.put("名","sun");
		context.put(null,"aa");
//		context.put(null,null);
		for (Map.Entry<String,String>  entry :context.entrySet()) {
			System.out.println(entry.getValue()+"=="+entry.getKey() );
		}

	}
	@Test
	public void Base() throws Exception{
		String base64encodedString = Base64.getEncoder().encodeToString("2".getBytes("utf-8"));
		System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);

		byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

		System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));

	}
}
