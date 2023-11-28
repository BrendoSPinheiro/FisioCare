package br.com.brendosp.fisiocare.common.exceptions;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {

  private final Integer code;

  private UserException(String message, Integer code) {
    super(message);
    this.code = code;
  }

  public static UserException usernameAlreadyInUse() {
    return new UserException("The username provided is already in use", HttpStatus.CONFLICT.value());
  }

  public static UserException emailAlreadyInUse() {
    return new UserException("The email provided is already in use", HttpStatus.CONFLICT.value());
  }

  public Integer getCode() {
    return code;
  }
}
