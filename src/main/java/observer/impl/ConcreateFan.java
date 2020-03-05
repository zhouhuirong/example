package observer.impl;

import observer.Fan;

/**
 * 具体观察者
 */
public class ConcreateFan implements Fan {

    private String fanName;

    public ConcreateFan(String fanName) {
        this.fanName = fanName;
    }

    @Override
    public void update(String message) {
        System.out.println(this.fanName+"接收到【"+message+"】这条消息");
    }
}
