package proxy;

import proxy.impl.BuyHouseImpl;
import proxy.impl.DecorationImpl;

public class Test {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        Decoration decoration = new DecorationImpl();
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
        buyHouseProxy.buyHouse();
        DecorationProxy decorationProxy = new DecorationProxy(decoration);
        decorationProxy.decoration();
    }
}
