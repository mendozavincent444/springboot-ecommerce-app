package com.luv2code.springbootecommerce.exception;

import com.luv2code.springbootecommerce.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                      WebRequest webRequest) {

    ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));

    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }


}
