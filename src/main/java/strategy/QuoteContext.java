package strategy;

import java.math.BigDecimal;
// 报价上下文
public class QuoteContext {
    private IQuoteStrategy quoteStrategy;

    public QuoteContext(IQuoteStrategy quoteStrategy) {
        this.quoteStrategy = quoteStrategy;
    }

    public BigDecimal getPrice(BigDecimal originalPrice){
        return quoteStrategy.getPrice(originalPrice);
    }
}
