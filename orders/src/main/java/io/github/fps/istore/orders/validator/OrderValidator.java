package io.github.fps.istore.orders.validator;

import feign.FeignException;
import io.github.fps.istore.orders.client.ClientsClient;
import io.github.fps.istore.orders.client.ProductClient;
import io.github.fps.istore.orders.client.representation.ProductRepresetation;
import io.github.fps.istore.orders.model.Order;
import io.github.fps.istore.orders.model.OrderItem;
import io.github.fps.istore.orders.model.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderValidator {
    private final ProductClient productClient;
    private final ClientsClient clientsClient;

    public  void validate(Order input){
        validadeClient(input.getCustomerId());
        input.getItens().forEach(this::validateProducts);
    }

    private void validadeClient(Long input){
       try{
           var response = clientsClient.get(input);
           var client = response.getBody();
           log.info("Client Valid");
       }catch (FeignException.NotFound e){
            throw new ValidationException("invalidCodeClient", "Invalid Client");
       }
    }

    private void validateProducts(OrderItem input){
        try{
            var response = productClient.get(input.getProductId());
            var product = response.getBody();
            log.info("product Valid");
        }catch (FeignException.NotFound e){
            var message = String.format("Code Product %d not found",input.getProductId());
            throw new ValidationException("invalidCodeProduct", message);
        }
    }
}
