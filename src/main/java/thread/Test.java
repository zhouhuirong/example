package thread;

import thread.runnable.ImplThread;
import thread.thread.ExtendsThread;

public class Test {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            Thread thread = new ExtendsThread();
            thread.start();
            Thread thread1 = new Thread(new ImplThread());
            thread1.start();
        }
    }
}
