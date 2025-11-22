package io.github.fps.istore.orders.controller.dto;

import java.math.BigDecimal;

public record OrderItemDTO(Long productId, Integer quantity, BigDecimal unitPrice) {
}
