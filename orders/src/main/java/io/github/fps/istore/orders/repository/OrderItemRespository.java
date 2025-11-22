package io.github.fps.istore.orders.repository;

import io.github.fps.istore.orders.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRespository extends JpaRepository<OrderItem,Long> {
}
