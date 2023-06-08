package com.luv2code.springbootecommerce.controller;

import com.luv2code.springbootecommerce.payload.ProductDto;
import com.luv2code.springbootecommerce.payload.ProductResponse;
import com.luv2code.springbootecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }


  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping
  public ResponseEntity<List<ProductDto>> getProducts() {
    List<ProductDto> productDtoList = this.productService.getProducts();

    return new ResponseEntity<>(productDtoList, HttpStatus.OK);
  }


  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getProductById(@PathVariable long id) {
    ProductDto productDto = this.productService.getProductById(id);

    return new ResponseEntity<>(productDto, HttpStatus.OK);
  }


  @GetMapping("/search/findByCategoryId")
  public ResponseEntity<ProductResponse> getAllProductsPagination(
          @RequestParam(value = "id") long id,
          @RequestParam(value = "page") int pageNo,
          @RequestParam(value = "size") int pageSize) {

    ProductResponse productResponse = this.productService.getAllProductsByCategoryId(id, pageNo, pageSize);

    return new ResponseEntity<>(productResponse, HttpStatus.OK);

  }


  /*
  @GetMapping("/search/findByCategoryId")
  public ResponseEntity<List<ProductDto>> getAllProductsByCategoryId(@RequestParam(value = "id") long id) {

    List<ProductDto> productDtoList = this.productService.getAllProductsByCategoryId(id);

    return new ResponseEntity<>(productDtoList, HttpStatus.OK);

  }
  */

  @GetMapping("/search/findByNameContaining")
  public ResponseEntity<ProductResponse> searchProductsByName(
          @RequestParam(value = "name") String keyword,
          @RequestParam(value = "page") int pageNo,
          @RequestParam(value = "size") int pageSize) {

    ProductResponse productResponse = this.productService.searchByName(keyword, pageNo, pageSize);

    return ResponseEntity.ok(productResponse);
  }

}
