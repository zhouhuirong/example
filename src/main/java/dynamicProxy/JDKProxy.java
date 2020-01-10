package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *需要有顶层接口才能使用，但是在只有顶层接口的时候也可以使用，常见是mybatis的mapper文件是代理。
 * 使用反射完成。使用了动态生成字节码技术。
 */
public class JDKProxy implements InvocationHandler {
    // 需要代理的目标对象
    private Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("addUser".equals(method.getName()) || "payWage".equals(method.getName())){
            System.out.println("校验信息");
            Object invoke = method.invoke(target, args);
            return invoke;
        }else {
            Object invoke = method.invoke(target, args);
            return invoke;
        }
    }
    // 生成代理类
    public Object creatProxyObj(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
