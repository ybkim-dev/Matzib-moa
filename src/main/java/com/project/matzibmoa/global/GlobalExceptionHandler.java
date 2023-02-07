package com.project.matzibmoa.global;

import java.net.BindException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<String> handleRuntimeException(RuntimeException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }

  @ExceptionHandler(ModelAttributeArgumentNotValidException.class)
  protected ResponseEntity<String> handleModelAttributeArgumentException(ModelAttributeArgumentNotValidException e) {
    log.error("bad Request");
    return ResponseEntity.badRequest().body(e.getMessage());
  }

}
