package outClass;

public class Outer {
    private class InnerOne extends FatherOne{
        private String name;
        private void fun(){
            System.out.println("sss");
        }
    }

    private class InnerTwo extends FatherTwo{

    }
    public String name(){
        class A extends FatherTwo{

        }
        System.out.println(new A().age());
        return new InnerOne().name("");
    }
    public int age(){
        return new InnerTwo().age();
    }

    public static void main(String[] args) {
        Outer o = new Outer();
        o.new InnerOne().fun();
        System.out.println(o.age()+o.name());
    }
}
