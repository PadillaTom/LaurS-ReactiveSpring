package com.example.sr_c1_e1.controllers;

import com.example.sr_c1_e1.model.Product;
import com.example.sr_c1_e1.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * They are not called Endpoints anymore. This is not a REST Service.
   * We must specify that we will work with STREAMS
   * to prevent returning everything at the end. (Like a normal endpoint)
   *
   * This is "the point for a client to connect and get a succession of events."
   * Specify it produces an EVENT_STREAM
   *
   *
   * @return
   */
  @GetMapping(value = "/product", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Product> getProduct() {
    return productService.getProducts();
  }

}
