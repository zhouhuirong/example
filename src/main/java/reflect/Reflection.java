package reflect;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.Method;

public class Reflection {
    @Test
    public void test ()throws Exception {
        Class getClass = Class.forName("reflect.UserEntity");
        UserEntity user = (UserEntity)getClass.newInstance();

        Method borrow = getClass.getMethod("borrow", int.class);
        borrow.invoke(user,200);

        Method repay = getClass.getMethod("repay",String.class, int.class);
        repay.invoke(user,"小明",300);

        Method getMoney = getClass.getMethod("getMoney");
        Integer money = (Integer)getMoney.invoke(user);
        System.out.println("一共有"+money);
    }
    @Test
    public void test1(){
        UserEntity u = new UserEntity();
//        u.setUserName("xx");
//        u.setUserName1("xx1");
        u.setUserAge(1);
        System.out.println(u);
        String valid = NoteFilter.valid(u);
        if (StringUtils.isNotBlank(valid)){
            System.out.println(valid);
        }else {
            System.out.println("xx");
        }
    }
}
