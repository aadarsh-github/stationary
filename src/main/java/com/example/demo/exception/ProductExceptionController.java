/**
 * 
 */
package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author AAdarsh
 *
 */
@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<Object> exception(ProductException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
