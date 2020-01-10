package lambda;

import java.util.Optional;

import json.Person;

public class LambdaOptional {
	
	public static void main(String[] args) {
		Integer i = null;
		Integer j = new Integer(10);
		Person p = new Person("haha", 1, "www");
		Optional<Person> a = Optional.ofNullable(p);
		System.out.println(a.isPresent());
		if (a.isPresent()) {
			System.out.println(a.get().getName());
		}
	}
	
}
