package callBack;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public class doHomeWork implements DoJob {

        @Override
        public void fillBlank(int a, int b, int result) {
            System.out.println(name + "使用超级计算机计算："+a+"+" +b+"="+result);
        }
    }

    public void callHelp (int a, int b){
        new SuperCalculator().add(a,b,new doHomeWork());
    }
}
