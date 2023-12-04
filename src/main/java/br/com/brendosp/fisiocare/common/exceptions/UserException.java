package br.com.brendosp.fisiocare.common.exceptions;

import org.springframework.http.HttpStatus;

public class UserException extends BaseException {

  private UserException(String message, Integer code) {
    super(message, code);
  }

  public static UserException usernameAlreadyInUse() {
    return new UserException("The username provided is already in use", HttpStatus.CONFLICT.value());
  }

  public static UserException emailAlreadyInUse() {
    return new UserException("The email provided is already in use", HttpStatus.CONFLICT.value());
  }
}
