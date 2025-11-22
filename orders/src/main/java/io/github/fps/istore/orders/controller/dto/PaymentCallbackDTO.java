package io.github.fps.istore.orders.controller.dto;

public record PaymentCallbackDTO(Long code, String paymentKey,boolean status, String observation) {
}
