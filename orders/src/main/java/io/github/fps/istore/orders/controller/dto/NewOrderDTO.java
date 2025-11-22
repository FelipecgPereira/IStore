package io.github.fps.istore.orders.controller.dto;

import java.util.List;

public record NewOrderDTO(Long customerId, PaymentDetailsDTO detailsPayment,
                          List<OrderItemDTO> itens) {
}
