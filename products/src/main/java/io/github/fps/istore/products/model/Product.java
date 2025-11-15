package io.github.fps.istore.products.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Table(name="products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "unit_price", nullable = false, precision = 16 , scale = 2)
    private BigDecimal unitPrice;

}
