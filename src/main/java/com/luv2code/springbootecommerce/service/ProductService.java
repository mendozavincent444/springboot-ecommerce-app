package com.luv2code.springbootecommerce.service;

import com.luv2code.springbootecommerce.entity.Product;
import com.luv2code.springbootecommerce.payload.ProductDto;
import com.luv2code.springbootecommerce.payload.ProductResponse;

import java.util.List;

public interface ProductService {

  public List<ProductDto> getProducts();

  public ProductDto getProductById(Long id);

  public ProductResponse getAllProductsByCategoryId(long id, int pageNo, int pageSize);

  public List<ProductDto> getAllProductsByCategoryId(long id);

  public ProductResponse searchByName(String name, int pageNo, int pageSize);

}
