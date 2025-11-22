package io.github.fps.istore.orders.controller;

import io.github.fps.istore.orders.controller.dto.PaymentCallbackDTO;
import io.github.fps.istore.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders/callback-payments")
@RequiredArgsConstructor
public class PaymentCallbackController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Object>updateCallback(
            @RequestBody PaymentCallbackDTO body,
            @RequestHeader(required = true,name = "apiKey") String apiKey
            ){
        orderService.updateStatusPayment(body.code(),
                body.paymentKey(),
                body.status(),
                body.observation());

        return ResponseEntity.ok().build();
    }
}
