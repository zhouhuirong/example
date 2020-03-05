package observer;

import observer.impl.ConcreateFan;
import observer.impl.ConcreteSubject;

/**
 * 观察者
 */
public class ObserverTest {
    public static void main(String[] args) {

        IDol iDol = new ConcreteSubject();
        Fan fanA = new ConcreateFan("小马");
        Fan fanB = new ConcreateFan("小米");
        Fan fanC = new ConcreateFan("小明");
        iDol.addFan(fanA);
        iDol.addFan(fanB);
        iDol.addFan(fanC);

        iDol.delFan(fanB);

        iDol.notify("嘿嘿");
    }
}
