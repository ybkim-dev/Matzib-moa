package com.project.matzibmoa.global;

import lombok.Getter;

@Getter
public class ModelAttributeArgumentNotValidException extends RuntimeException{

  private final String message = "매개변수가 잘못되었습니다.";

  public ModelAttributeArgumentNotValidException() {
  }
}
