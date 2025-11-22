package io.github.fps.istore.orders.client;

import io.github.fps.istore.orders.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class BankServiceClient {

    public String requestPayment(Order input){
        log.info("Request payment to order {}", input.getId());
        return UUID.randomUUID().toString();
    }
}
