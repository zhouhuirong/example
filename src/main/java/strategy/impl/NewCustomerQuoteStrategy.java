package strategy.impl;

import strategy.IQuoteStrategy;

import java.math.BigDecimal;

public class NewCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        System.out.println("无折扣");
        return originalPrice;
    }
}
