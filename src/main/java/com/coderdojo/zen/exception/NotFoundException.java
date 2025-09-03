package com.coderdojo.zen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Javadoc.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

  /**
   * Javadoc.
   *
   * @param message Example
   */
  public NotFoundException(String message) {
    super(message);
  }
}
