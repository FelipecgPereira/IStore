package io.github.fps.istore.orders.controller.mappers;

import io.github.fps.istore.orders.controller.dto.NewOrderDTO;
import io.github.fps.istore.orders.controller.dto.OrderItemDTO;
import io.github.fps.istore.orders.model.Order;
import io.github.fps.istore.orders.model.OrderItem;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static io.github.fps.istore.orders.model.enums.OrderStatus.PLACED;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderItemMapper ORDER_ITEM_MAPPER = Mappers.getMapper(OrderItemMapper.class);


    @Mapping(source = "itens", target = "itens", qualifiedByName = "mapItens")
    @Mapping(source = "detailsPayment", target = "detailsPayment")
    Order map(NewOrderDTO input);

    @Named("mapItens")
    default List<OrderItem> mapItens(List<OrderItemDTO> dtos){
        return dtos.stream().map(ORDER_ITEM_MAPPER::map).toList();
    }

    @AfterMapping
    default void afterMapping(@MappingTarget Order input){
        input.setStatus(PLACED);
        input.setOrderDate(LocalDateTime.now());

        var total = sumTotal(input);

        input.setTotal(total);

        input.getItens().forEach(item -> item.setOrder(input));
    }


    private static  BigDecimal sumTotal(Order input) {

        return input.getItens().stream().map(item ->
                item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
        ).reduce(BigDecimal.ZERO, BigDecimal::add).abs();
    }
}
