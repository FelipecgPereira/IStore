package io.github.fps.istore.orders.model;

import io.github.fps.istore.orders.model.enums.PaymentType;
import lombok.Data;

@Data
public class DatailsPayment {
    String details;
    PaymentType paymentType;
}
