package dynamicProxy.impl;

import dynamicProxy.WageManager;

public class WageMangerImpl implements WageManager {
    @Override
    public void payWage(Integer money) {
        System.out.println("发工资"+money);
    }
}
