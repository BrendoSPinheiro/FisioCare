package br.com.brendosp.fisiocare.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  public record ErrorResponseDto(String message, Integer code) {}

  @ExceptionHandler(UserException.class)
  public ResponseEntity<ErrorResponseDto> handleUserException(UserException exception) {
    return buildErrorResponse(exception.getMessage(), exception.getCode());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDto> handleException(Exception exception) {
    return buildErrorResponse("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

  private ResponseEntity<ErrorResponseDto> buildErrorResponse(String message, Integer code) {
    var errorResponseDto = new ErrorResponseDto(message, code);

    return ResponseEntity.status(code).body(errorResponseDto);
  }
}
