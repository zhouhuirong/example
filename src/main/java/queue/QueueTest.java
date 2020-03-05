package queue;

public class QueueTest {
    public static void main(String[] args) {

        Queue q = new Queue(10);
        q.push(10);
        q.push(15);
        q.push(17);
        q.push(19);
        int p1 = q.pop();
        System.out.println(p1);
        q.push(120);
        int p2 = q.pop();
        System.out.println(p2);
        System.out.println(q);
        q.remove();
        int p3 = q.pop();
        System.out.println(p3);
        System.out.println(q);
    }
}
