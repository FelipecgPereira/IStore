package io.github.fps.istore.orders.controller.dto;

import io.github.fps.istore.orders.model.enums.PaymentType;

public record NewPaymentDTO(Long code, String details, PaymentType typePayment) {
}
