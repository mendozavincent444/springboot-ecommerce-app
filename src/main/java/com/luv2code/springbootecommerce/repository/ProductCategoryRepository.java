package com.luv2code.springbootecommerce.repository;

import com.luv2code.springbootecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
