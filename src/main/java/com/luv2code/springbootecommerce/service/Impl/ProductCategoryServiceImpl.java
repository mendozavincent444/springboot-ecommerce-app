package com.luv2code.springbootecommerce.service.Impl;

import com.luv2code.springbootecommerce.entity.ProductCategory;
import com.luv2code.springbootecommerce.payload.ProductCategoryDto;
import com.luv2code.springbootecommerce.repository.ProductCategoryRepository;
import com.luv2code.springbootecommerce.service.ProductCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

  private final ProductCategoryRepository productCategoryRepository;
  private ModelMapper modelMapper;

  public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, ModelMapper modelMapper) {
    this.productCategoryRepository = productCategoryRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<ProductCategoryDto> getAllCategories() {

    List<ProductCategory> productCategoryList = this.productCategoryRepository.findAll();

    List<ProductCategoryDto> productCategoryDtos = productCategoryList.stream().map((productCategory -> this.mapToDto(productCategory))).collect(Collectors.toList());

    return productCategoryDtos;
  }

  private ProductCategoryDto mapToDto(ProductCategory productCategory) {
    ProductCategoryDto productCategoryDto = this.modelMapper.map(productCategory, ProductCategoryDto.class);
    return productCategoryDto;
  }

  private ProductCategory mapToEntity(ProductCategoryDto productCategoryDto) {
    ProductCategory productCategory = this.modelMapper.map(productCategoryDto, ProductCategory.class);
    return productCategory;
  }
}
