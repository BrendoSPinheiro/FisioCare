package br.com.brendosp.fisiocare.common.exceptions;

import br.com.brendosp.fisiocare.infra.http.dtos.response.ErrorResponseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(UserException.class)
  public ResponseEntity<ErrorResponseDto> handleUserException(UserException exception) {
    logger.error("UserException: {}", exception.getMessage());
    return buildErrorResponse(exception.getMessage(), exception.getCode());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDto> handleException(Exception exception) {
    logger.error("Exception: {}", exception.getMessage());
    return buildErrorResponse("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

  private ResponseEntity<ErrorResponseDto> buildErrorResponse(String message, Integer code) {
    var errorResponseDto = new ErrorResponseDto(message, code);

    return ResponseEntity.status(code).body(errorResponseDto);
  }
}
