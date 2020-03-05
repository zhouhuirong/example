package observer;

/**
 * 被观察者接口 ，主题
 */
public interface IDol {

    public void addFan(Fan fan);

    public void delFan(Fan fan);

    public void notify(String message);

}

