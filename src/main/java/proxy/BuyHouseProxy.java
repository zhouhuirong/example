package proxy;

public class BuyHouseProxy implements BuyHouse{

    private BuyHouse buyHouse;

    public BuyHouseProxy(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        System.out.println("选购");
        buyHouse.buyHouse();
    }

}
