package dynamicProxy.impl;

import dynamicProxy.UserManager;

public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String name, Integer age) {
        System.out.println("新增用户"+name);
    }

    @Override
    public void deleteUser(String name) {
        System.out.println("删除用户"+name);
    }
}
