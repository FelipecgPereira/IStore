package io.github.fps.istore.products.repository;

import io.github.fps.istore.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
