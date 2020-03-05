package linked;

import org.junit.Test;

public class LinkTest {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        House h = new House("广州");
        House h2 = new House("邵阳");
        House h3 = new House("抚州");
        House h4 = new House("临川");
        House h5 = new House("四川");
        list.add(h);
        list.add(h2);
        list.add(h3);
        list.add(h4);
        System.out.println(list);
        Object o = list.get(2);
        System.out.println(o);
//        list.add(3,h5);
        list.remove(3);
        System.out.println(list);
    }
    @Test
    public void test(){
        LinkedList list = new LinkedList();
        House h = new House("广州");
        House h2 = new House("邵阳");
        House h3 = new House("抚州");
        House h4 = new House("临川");
        list.add(h);
        list.add(h2);
        list.add(h3);
        list.add(h4);
        System.out.println(list.findNode(2));
        System.out.println(list.first());
        System.out.println(list.last());
    }
}
