package io.github.fps.istore.orders.service;

import io.github.fps.istore.orders.client.BankServiceClient;
import io.github.fps.istore.orders.model.DetailsPayment;
import io.github.fps.istore.orders.model.Order;
import io.github.fps.istore.orders.model.enums.PaymentType;
import io.github.fps.istore.orders.model.exception.ItemNotFoundException;
import io.github.fps.istore.orders.repository.OrderItemRespository;
import io.github.fps.istore.orders.repository.OrderRepository;
import io.github.fps.istore.orders.validator.OrderValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static io.github.fps.istore.orders.model.enums.OrderStatus.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository repository;
    private final OrderItemRespository itemRespository;
    private final OrderValidator validator;
    private final BankServiceClient bankClient;



    @Transactional
    public Order save(Order input){
        validator.validate(input);
        persistOrder(input);
        getPayment(input);
        return  input;
    }

    private void getPayment(Order input) {
        var key = bankClient.requestPayment(input);
        input.setPaymentKey(key);
    }

    private void persistOrder(Order input) {
        repository.save(input);
        itemRespository.saveAll(input.getItens());
    }

    public void updateStatusPayment(Long codeOder, String paymentKey, boolean status, String observation) {
        var orderFound = repository.findByIdAndPaymentKey(codeOder,paymentKey);

        if(orderFound.isEmpty()){
            var msg = String.format("Oder payment key %s not found ",paymentKey);

            log.error(msg);
            return;
        }

        var order = orderFound.get();

        if(status){
            order.setStatus(PAID);
        }else{
            order.setStatus(PAYMENT_ERROR);
            order.setNotes(observation);
        }

        repository.save(order);
    }
    @Transactional
    public void newPayment(Long orderCode, String paymentDetails, PaymentType type){
        var orderFound = repository.findById(orderCode);

        if(orderFound.isEmpty()){
            throw  new ItemNotFoundException("Order not found");
        }

        var order = orderFound.get();

        var detailsPayment = new DetailsPayment();
        detailsPayment.setDetails(paymentDetails);
        detailsPayment.setPaymentType(type);
        order.setDetailsPayment(detailsPayment);
        order.setStatus(PLACED);
        order.setNotes("New payment");

        repository.save(order);

        var newPaymentKey = bankClient.requestPayment(order);
        order.setPaymentKey(newPaymentKey);

    }
}
