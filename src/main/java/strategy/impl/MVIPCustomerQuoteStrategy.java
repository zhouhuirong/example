package strategy.impl;

import strategy.IQuoteStrategy;

import java.math.BigDecimal;

public class MVIPCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        System.out.println("七折");
        BigDecimal multiply = originalPrice.multiply(new BigDecimal(0.7).setScale(2, BigDecimal.ROUND_HALF_UP));
        return multiply;
    }
}
