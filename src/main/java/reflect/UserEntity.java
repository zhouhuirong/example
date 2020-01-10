package reflect;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class UserEntity {
    @NotNull(message = "不能为空")
    private  int money = 1000;
    @NotNull(message = "用户名不能为空")
    private String userName;
    @NotNull(message = "用户名1不能为空")
    private String userName1;
    @NotNull(message = "age不能为空")
    private Integer userAge;

    @NotNull(message = "alist不能为空")
    private List list = new ArrayList();

    public UserEntity() {
    }

    public UserEntity(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

//    public int getMoney() {
//        return money;
//    }
//
//    public void setMoney(int money) {
//        this.money = money;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public void setUserAge(Integer userAge) {
//        this.userAge = userAge;
//    }
//
//    public List getList() {
//        return list;
//    }
//
//    public void setList(List list) {
//        this.list = list;
//    }
//
//    public String getUserName1() {
//        return userName1;
//    }
//
//    public void setUserName1(String userName1) {
//        this.userName1 = userName1;
//    }
//
//    public Integer getUserAge() {
//        return userAge;
//    }
//
//    public void borrow(int money){
//        System.out.println("借了"+money+"元");
//        this.money = this.money + money;
//    }
//
//    public  void repay(int money){
//        System.out.println("还了"+money+"元");
//        this.money = this.money -money;
//    }
//
//    public void repay(String name, int money){
//        System.out.println("还了"+name+money+"元");
//        this.money = this.money -money;
//    }
}
