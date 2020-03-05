package stack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(10);
        stack.push(20);
        int pop1 = stack.pop();
        System.out.println(pop1);
        stack.push(30);
        stack.push(33);
        int pop2 = stack.pop();
        System.out.println(pop2);

    }
}
