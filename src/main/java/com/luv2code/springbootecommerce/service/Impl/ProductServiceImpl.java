package com.luv2code.springbootecommerce.service.Impl;

import com.luv2code.springbootecommerce.entity.Product;
import com.luv2code.springbootecommerce.exception.ResourceNotFoundException;
import com.luv2code.springbootecommerce.payload.ProductDto;
import com.luv2code.springbootecommerce.payload.ProductResponse;
import com.luv2code.springbootecommerce.repository.ProductRepository;
import com.luv2code.springbootecommerce.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private ModelMapper modelMapper;

  public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
    this.productRepository = productRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<ProductDto> getProducts() {
    List<Product> products = this.productRepository.findAll();

    List<ProductDto> productsDto = products.stream().map(product -> this.modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());

    return productsDto;
  }

  @Override
  public ProductDto getProductById(Long id) {
    Product product = this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

    return this.mapToDto(product);
  }


  @Override
  public ProductResponse getAllProductsByCategoryId(long id, int pageNo, int pageSize) {

    Pageable pageable = PageRequest.of(pageNo, pageSize);

    Page<Product> products = this.productRepository.findByCategoryId(id, pageable);

    List<Product> productList = products.getContent();

    List<ProductDto> content = productList.stream().map(product -> this.mapToDto(product)).collect(Collectors.toList());

    ProductResponse productResponse = new ProductResponse();
    productResponse.setContent(content);
    productResponse.setPageNo(products.getNumber());
    productResponse.setPageSize(products.getSize());
    productResponse.setTotalElements(products.getTotalElements());
    productResponse.setTotalPages(products.getTotalPages());

    return productResponse;
  }


  @Override
  public List<ProductDto> getAllProductsByCategoryId(long id) {


    List<Product> products = this.productRepository.findByCategoryId(id);


    List<ProductDto> content = products.stream().map(product -> this.mapToDto(product)).collect(Collectors.toList());

    return content;
  }

  @Override
  public ProductResponse searchByName(String name, int pageNo, int pageSize) {


    Pageable pageable = PageRequest.of(pageNo, pageSize);

    Page<Product> products = this.productRepository.findByNameContaining(name, pageable);

    List<Product> content = products.getContent();

    List<ProductDto> productDtos = content.stream().map(product -> this.mapToDto(product)).collect(Collectors.toList());

    ProductResponse productResponse = new ProductResponse();

    productResponse.setContent(productDtos);
    productResponse.setPageNo(products.getNumber());
    productResponse.setPageSize(products.getSize());
    productResponse.setTotalElements(products.getTotalElements());
    productResponse.setTotalPages(products.getTotalPages());

    return productResponse;
  }


  private ProductDto mapToDto(Product product) {
    ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
    return productDto;
  }

  private Product mapToEntity(ProductDto productDto) {
    Product product = this.modelMapper.map(productDto, Product.class);
    return product;
  }
}
