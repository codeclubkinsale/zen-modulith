package com.coderdojo.zen.exception;

import java.net.URI;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Javadoc.
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

  /**
   * Sole constructor. (For invocation by subclass
   * constructors, typically implicit.).
   */
  GlobalControllerExceptionHandler() { /* Default Constructor */
  }

  /**
   * Javadoc.
   *
   * @param exception Example
   * @return Example
   */
  @ExceptionHandler(MethodArgumentConversionNotSupportedException.class)
  public ErrorResponse handleBadRequestException(
      MethodArgumentConversionNotSupportedException exception) {
    return getErrorResponse(
        "Bad Request",
        400,
        "Please check documentation for parameters/body",
        exception
    );
  }

  /**
   * Javadoc.
   *
   * @param exception Example
   * @return Example
   */
  @ExceptionHandler({NoHandlerFoundException.class, MethodArgumentTypeMismatchException.class,
      NoSuchElementException.class})
  public ErrorResponse handleNotFoundException(Exception exception) {
    return getErrorResponse(
        "Not Found",
        404,
        "Please check documentation for available endpoints",
        exception
    );
  }

  /**
   * Javadoc.
   *
   * @param exception Example
   * @return Example
   */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ErrorResponse handleMethodNotSupportedException(
      HttpRequestMethodNotSupportedException exception) {
    return getErrorResponse(
        "Method Not Allowed",
        405,
        "Please check documentation for available methods",
        exception
    );
  }

  /**
   * Javadoc.
   *
   * @param title      Example
   * @param statusCode Example
   * @param detail     Example
   * @param exception  Example
   * @return Example
   */
  private ErrorResponse getErrorResponse(String title, int statusCode, String detail,
                                         Exception exception) {
    return ErrorResponse.builder(exception, HttpStatusCode.valueOf(statusCode), detail)
        .type(URI.create(exception.getClass().getSimpleName()))
        .title(title).build();
  }
}
