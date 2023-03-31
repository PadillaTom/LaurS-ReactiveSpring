package com.example.sr_c1_e1.services;

import com.example.sr_c1_e1.model.Product;
import com.example.sr_c1_e1.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  /**
   * Flux is a pipeline of created events (Product is the event).
   * Reactive Repository: Will return Flux or Mono (Publisher: Creates events).
   *                      It will return one element after the other instead of waiting to fetch
   *                      the entire collection of elements in DB.
   * CRUD Repository: It returns a Collection of elements. It waits to fetch all before returning.
   *
   * @return
   */
  public Flux<Product> getProducts() {
    return productRepository.findAll()
        .delayElements(Duration.ofSeconds(5))   // Added to showcase the Fetch of elements one by one
            .log();                             // Added to show Logs
  }

}
