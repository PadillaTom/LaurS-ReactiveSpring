package com.example.sr_c2_e1.model;

import org.springframework.data.annotation.Id;

public class Product {

  @Id
  private Integer id;
  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
