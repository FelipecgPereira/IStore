package io.github.fps.istore.products.controller;

import io.github.fps.istore.products.model.Product;
import io.github.fps.istore.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product input){
        service.save(input);
        return ResponseEntity.ok(input);
    }

    @GetMapping("{code}")
    public ResponseEntity<Product> get(@PathVariable("code") Long code){
        return  service.getProductById(code).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
}
