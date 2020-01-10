package proxy;

public class DecorationProxy implements Decoration {
    private Decoration decoration;

    public DecorationProxy(Decoration decoration) {
        this.decoration = decoration;
    }

    @Override
    public void decoration() {
        System.out.println("材料");
        decoration.decoration();
    }
}
