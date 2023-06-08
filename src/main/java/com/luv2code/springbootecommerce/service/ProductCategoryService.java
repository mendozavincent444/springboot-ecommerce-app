package com.luv2code.springbootecommerce.service;

import com.luv2code.springbootecommerce.payload.ProductCategoryDto;
import java.util.List;

public interface ProductCategoryService {
  List<ProductCategoryDto> getAllCategories();
}
