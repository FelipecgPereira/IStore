package io.github.fps.istore.orders.client;

import io.github.fps.istore.orders.client.representation.ProductRepresetation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products", url="${istore.orders.clients.products.url}")
public interface ProductClient {
    @GetMapping("{code}")
    ResponseEntity<ProductRepresetation>get(@PathVariable("code") Long code);
}
