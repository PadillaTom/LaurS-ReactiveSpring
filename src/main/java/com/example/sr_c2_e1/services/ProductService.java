package com.example.sr_c2_e1.services;

import com.example.sr_c2_e1.model.Product;
import com.example.sr_c2_e1.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class ProductService {

  private ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Flux<Product> getAll() {
    return productRepository.findAll().delayElements(Duration.ofMillis(4000)).log();
  }
}
