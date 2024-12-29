package com.springboot.testwebapp.exception;

public class InvalidAgeException extends RuntimeException {
  public InvalidAgeException(String message) {
    super(message);
  }
}
