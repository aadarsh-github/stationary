/**
 * 
 */
package com.example.demo.exception;

/**
 * @author AAdarsh
 *
 */
public class ProductException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 404349359600488846L;
	
	public ProductException() {
        super();
    }
	
	public ProductException(String message) {
        super(message);
    }

}
