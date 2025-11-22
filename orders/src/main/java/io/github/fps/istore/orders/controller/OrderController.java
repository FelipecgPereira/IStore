package io.github.fps.istore.orders.controller;

import io.github.fps.istore.orders.controller.dto.NewOrderDTO;
import io.github.fps.istore.orders.controller.mappers.OrderMapper;
import io.github.fps.istore.orders.model.exception.ErroResponse;
import io.github.fps.istore.orders.model.exception.ValidationException;
import io.github.fps.istore.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;
    private final OrderMapper mapper;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody NewOrderDTO input){
       try{
           var order = mapper.map(input);
           service.save(order);
           return ResponseEntity.ok(order.getId());
       }catch (ValidationException e){
          var erro = new ErroResponse("Error validate",e.getField(),e.getMessage());
          return ResponseEntity.badRequest().body(erro);
       }
    }
}
