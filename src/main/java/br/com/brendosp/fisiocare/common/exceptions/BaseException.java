package br.com.brendosp.fisiocare.common.exceptions;

public class BaseException extends RuntimeException {

  private final Integer code;

  public BaseException(String message, Integer code) {
    super(message);
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }
}
