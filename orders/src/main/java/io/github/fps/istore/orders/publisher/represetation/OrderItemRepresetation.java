package io.github.fps.istore.orders.publisher.represetation;

import java.math.BigDecimal;

public record OrderItemRepresetation(
        Long orderCode,
        String name,
        Integer quantity,
        BigDecimal unitPrice
) {

    public BigDecimal getTotal(){
        return  unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
