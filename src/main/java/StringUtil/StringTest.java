package StringUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import json.Adds;
import json.Person;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringTest {
    private List<Long> lists = new ArrayList<>();

    @Test
    public void joinStringList() {
        List<String> list = new ArrayList<>();
        list.add("ac");
        list.add("vc");
        list.add("rc");
        list.add("sc");
        list.add("xc");
        list.add("qc");
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder);
        for (String str : list) {
            if (StringUtils.isEmpty(stringBuilder)) {
                stringBuilder.append("('" + str + "'");
            } else {
                stringBuilder.append(",'" + str + "'");
            }
        }
        stringBuilder.append(")");
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void test1() {
        List<String> list = null;
        List<String> list2 = new ArrayList<String>();
        System.out.println(list == null);
        System.out.println(list2);
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4};
        for (int i : arr) {
            if (1 == 1) {
                if (2 == i) {
                    continue;
                }
                System.out.println(i);
            }
        }

    }

    @Test
    public void test3() {
        try {
            throw new Exception("参数越界");
        } catch (Exception e) {

        }
        System.out.println("aa");
    }

    @Test
    public void test4() {
        LocalDate endOfFeb = LocalDate.parse("2014-02-28");
        LocalDate date = LocalDate.now();
        long time = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(time / 1000, 0, ZoneOffset.ofHours(8));
        System.out.println(endOfFeb.getYear());
        System.out.println(date);
        System.out.println(time);
        System.out.println(localDateTime);
    }

    @Test
    public void test5() {
        Object o = 10;
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = o.toString();
        List list = new ArrayList();
        System.out.println(str.equals(o));
        System.out.println(localDateTime.toString() + "xxx" + localDateTime);
        System.out.println(list.toString() + "===" + list + "--" + StringUtils.isNotBlank(list.toString()));
        System.out.println(lists.toString() + "===" + lists + "--" + StringUtils.isNotBlank(lists.toString()));
    }

    @Test
    public void test6() {
        Person person = new Person();
        List<Adds> adds = person.getAdds();
        System.out.println(adds ==null);
        System.out.println(StringUtils.isNotBlank(person.getName()));

    }
    @Test
    public void test7(){
        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(9);
        stack.add(10);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
