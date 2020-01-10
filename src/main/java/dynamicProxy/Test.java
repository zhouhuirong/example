package dynamicProxy;

import dynamicProxy.impl.UserManagerImpl;
import dynamicProxy.impl.WageMangerImpl;

import java.lang.reflect.Proxy;

/**
 * 1、面向切面AOP
 * 把需要执行的方法看成一个个点，连接起来就是一个面。这些方法在执行的时候需要进行同一操作
 * 比如：校验、事务、日志等操作。通过面向切面就不需要每个方法单独进行重复的操作。
 * Spring默认使用JDKProxy实现动态代理，如果目标对象没有接口使用cglib动态代理
 * 2、如何实现面向切面的
 * 通过动态代理技术实现，通过反射获取被代理对象然后可以在代理类中调用目标对象的方法。既然可以调用方法
 * 那就可以在调用执行需要的各种操作
 * 3、如何实现动态代理
 *  a、JDKProxy动态代理 实现InvocationHandler接口 由JDK反射包提供
 *  b、cglib动态代理
 *
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        UserManager userManager = new UserManagerImpl();
        JDKProxy jdkProxy = new JDKProxy(userManager);
        UserManager user = (UserManager) jdkProxy.creatProxyObj();
        user.deleteUser("ss");

        WageMangerImpl wageManger = new WageMangerImpl();
        JDKProxy jdkProxyw = new JDKProxy(wageManger);
        WageManager wage = (WageManager)jdkProxyw.creatProxyObj();
        wage.payWage(10000);

        CglibProxy cglibProxy = new CglibProxy(userManager);
        UserManager userc = (UserManager)cglibProxy.CreatProxyObj();
        userc.addUser("小马",19);
    }
}
