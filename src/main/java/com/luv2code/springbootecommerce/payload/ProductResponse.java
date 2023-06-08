package com.luv2code.springbootecommerce.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

  private List<ProductDto> content;
  private int pageNo;
  private int pageSize;
  private Long totalElements;
  private int totalPages;
}
