package br.com.brendosp.fisiocare.common.exceptions;

public abstract class BaseException extends RuntimeException {

  private final Integer code;

  protected BaseException(String message, Integer code) {
    super(message);
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }
}
