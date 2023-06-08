package com.luv2code.springbootecommerce.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
  private String resourceName;
  private String fieldName;
  private Long fieldValue;


  public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
    super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }


}
