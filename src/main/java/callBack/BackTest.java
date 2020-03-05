package callBack;

/**
 * 回调和代理理念类似，为了将通用的功能独立出来进行复用。
 * 过滤器使用了回调
 */
public class BackTest {
    public static void main(String[] args) {
        Student student = new Student("小马");
        student.callHelp(100,111);
    }
}
