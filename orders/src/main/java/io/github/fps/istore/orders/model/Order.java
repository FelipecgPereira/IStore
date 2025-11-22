package io.github.fps.istore.orders.model;


import io.github.fps.istore.orders.client.representation.ClientRepresentation;
import io.github.fps.istore.orders.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "payment_key", columnDefinition = "text")
    private String paymentKey;

    @Column(name = "notes", columnDefinition = "text")
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private OrderStatus status;

    @Column(precision = 16, scale = 2, nullable = false)
    private BigDecimal total;

    @Column(name = "tracking_code", length = 255)
    private String trackingCode;

    @Column(name = "invoice_url", columnDefinition = "text")
    private String invoiceUrl;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<OrderItem> itens ;

    @Transient
    private DetailsPayment detailsPayment;

    @Transient
    private ClientRepresentation client;
}