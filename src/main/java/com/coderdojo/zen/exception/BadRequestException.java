package com.coderdojo.zen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Javadoc.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

  /**
   * Javadoc.
   *
   * @param message Example
   */
  public BadRequestException(String message) {
    super(message);
  }
}
