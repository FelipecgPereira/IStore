package io.github.fps.istore.orders.controller.mappers;

import io.github.fps.istore.orders.controller.dto.OrderItemDTO;
import io.github.fps.istore.orders.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItem map(OrderItemDTO input);
}
