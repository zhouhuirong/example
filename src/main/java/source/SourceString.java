package source;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.validation.constraints.NotNull;
import java.util.*;

public class SourceString {
    @Test
    public void CharToString(){
//        char [] chars = {'a','b','c','1',65};
//        String str = new String(chars);
//        System.out.println(str);
//
//        char [] c = new char[10];
//        c[0] = 'a';
//        c[1] = 'b';
//        System.out.println(new String(c));
//        String s = new String("AAAAq");
//        System.out.println(s);
//
//        String s1 = new String(chars,1,2);
//        System.out.println(s1);
        int [] i = {65,66,63,64,65,66,67,61,1,2,3,4,5,5,7,8,9};
        String s2 = new String(i,0,10);
        System.out.println("xx"+s2);

        String s3 = "Zabc";
        System.out.println(s2.compareTo(s3));
    }
    @Test
    public void IntegerSource(){
        Integer i = 10;
        List list = new ArrayList(6);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(1,99);
        System.out.println(list.get(0));

        List list1 = new LinkedList();
        list1.add(11);
        list1.add(112);
        list1.add(11);
        list1.add(111);
        list1.get(2);
        Collection c = new ArrayList();
        Map<String,String> m = new HashMap<>();
        m.put("q","Q");
        Set<Map.Entry<String, String>> entries = m.entrySet();
        for (Map.Entry<String, String> e :m.entrySet()) {

        }

    }

    @Test
    public void copy(){
        int [] array = {1,2,3,4,5,6,7,8,9,};
        int [] a =     {1,2,3,4,5,6,7,8,9,0};
        System.arraycopy(array,2,a,3,7);
        a[2] = 9;
        for (int i: a) {
            System.out.println(i);
        }
    }
}
