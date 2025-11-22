package io.github.fps.istore.orders.controller.dto;

import io.github.fps.istore.orders.model.enums.PaymentType;

public record PaymentDetailsDTO(String details, PaymentType paymentType) {
}
