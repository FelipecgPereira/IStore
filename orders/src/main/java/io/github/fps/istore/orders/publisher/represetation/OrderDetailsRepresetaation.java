package io.github.fps.istore.orders.publisher.represetation;

import io.github.fps.istore.orders.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

public record OrderDetailsRepresetaation(
        Long code,
        String customerId,
        String name,
        String taxId,
        String street,
        String number,
        String neighborhood,
        String email,
        String phone,
        String orderData,
        OrderStatus status,
        BigDecimal total,
        List<OrderItemRepresetation> itens

) {
}
