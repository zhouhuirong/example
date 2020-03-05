package strategy;

import strategy.impl.MVIPCustomerQuoteStrategy;
import strategy.impl.VIPCustomerQuoteStrategy;

import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) {
        IQuoteStrategy vip = new VIPCustomerQuoteStrategy();
        IQuoteStrategy mvip =new MVIPCustomerQuoteStrategy();
        QuoteContext quoteContext = new QuoteContext(mvip);
        BigDecimal price = quoteContext.getPrice(new BigDecimal(200));
        System.out.println(price);
    }
}
