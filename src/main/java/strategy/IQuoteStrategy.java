package strategy;

import java.math.BigDecimal;
//计算接口
public interface IQuoteStrategy {
    BigDecimal getPrice(BigDecimal originalPrice);
}
