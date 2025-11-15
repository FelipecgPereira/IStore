package io.github.fps.istore.products.service;

import io.github.fps.istore.products.model.Product;
import io.github.fps.istore.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product save(Product input){
       return repository.save(input);
    }

    public Optional<Product> getProductById(Long id){
        return repository.findById(id);
    }
}
