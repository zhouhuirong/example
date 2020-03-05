package array;

public class ArrayTest {
    public static void main(String[] args) {
        Array array = new Array(5);
        array.add(2);
        array.add(9);
        array.add(14);
        array.add(18);
//        array.remove(2);
//        array.remove(3);
        array.removeElement(5);
        System.out.println(array);
    }
}
