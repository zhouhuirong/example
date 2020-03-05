package strategy.impl;

import strategy.IQuoteStrategy;

import java.math.BigDecimal;

public class VIPCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        System.out.println("八折");
        BigDecimal multiply = originalPrice.multiply(new BigDecimal(0.8).setScale(2, BigDecimal.ROUND_HALF_UP));
        return multiply;
    }
}
