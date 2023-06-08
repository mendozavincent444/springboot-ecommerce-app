package com.luv2code.springbootecommerce.payload;

import com.luv2code.springbootecommerce.entity.ProductCategory;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
public class ProductDto {
  private long id;
  private String sku;
  private String name;
  private String description;
  private BigDecimal unitPrice;
  private String imageUrl;
  private boolean active;
  private int unitsInStock;
  private Date dateCreated;
  private Date lastUpdated;
}
