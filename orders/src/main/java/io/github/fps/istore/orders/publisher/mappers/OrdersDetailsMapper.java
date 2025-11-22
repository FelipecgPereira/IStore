package io.github.fps.istore.orders.publisher.mappers;


import io.github.fps.istore.orders.model.Order;
import io.github.fps.istore.orders.publisher.represetation.OrderDetailsRepresetaation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrdersDetailsMapper {

    @Mapping(target = "code", source = "id")
    @Mapping(target = "customerId", source = "customerId")
    @Mapping(target = "name", source = "client.name")
    @Mapping(target = "taxId", source = "client.taxId")
    @Mapping(target = "street", source = "client.street")
    @Mapping(target = "number", source = "client.number")
    @Mapping(target = "neighborhood", source = "client.neighborhood")
    @Mapping(target = "email", source = "client.email")
    @Mapping(target = "phone", source = "client.phone")
    @Mapping(target = "orderData", source = "orderDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "total", source = "total")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "itens", source = "itens")
    OrderDetailsRepresetaation map (Order input);
}
