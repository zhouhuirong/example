package BigData;

import java.math.BigDecimal;

public class AddMoney {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("10.00");
        BigDecimal b = new BigDecimal("-1");
        BigDecimal c = BigDecimal.ZERO;
        c = c.add(a).add(b);
        BigDecimal d = new BigDecimal("9");
        System.out.println(c+ "\n " +d);
        System.out.println(c.compareTo(d));
    }
}
