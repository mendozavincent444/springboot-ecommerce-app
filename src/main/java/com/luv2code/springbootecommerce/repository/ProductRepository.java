package com.luv2code.springbootecommerce.repository;

import com.luv2code.springbootecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

  //Page<Product> findByCategoryId(Long id, Pageable pageable);

  Page<Product> findByCategoryId(long id, Pageable pageable);
  Page<Product> findByNameContaining(String name, Pageable pageable);
  List<Product> findByCategoryId(long id);




}
