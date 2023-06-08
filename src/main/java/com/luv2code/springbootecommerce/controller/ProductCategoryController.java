package com.luv2code.springbootecommerce.controller;

import com.luv2code.springbootecommerce.payload.ProductCategoryDto;
import com.luv2code.springbootecommerce.service.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/product-categories")
public class ProductCategoryController {

  private final ProductCategoryService productCategoryService;

  public ProductCategoryController(ProductCategoryService productCategoryService) {
    this.productCategoryService = productCategoryService;
  }
  @GetMapping
  public ResponseEntity<List<ProductCategoryDto>> getAllCategories() {
    List<ProductCategoryDto> productCategoryDtos = this.productCategoryService.getAllCategories();

    return new ResponseEntity<>(productCategoryDtos, HttpStatus.OK);
  }


}
