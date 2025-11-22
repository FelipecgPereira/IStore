package io.github.fps.istore.orders.repository;

import io.github.fps.istore.orders.model.Order;
import io.github.fps.istore.orders.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRespository extends JpaRepository<OrderItem,Long> {
    List<OrderItem> findByOrder(Order input);
}
