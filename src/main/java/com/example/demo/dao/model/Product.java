/**
 * 
 */
package com.example.demo.dao.model;

/**
 * @author AAdarsh
 *
 */
public class Product {

	private String productName;
	private int quantity;
	private String message;

	public Product() {
	}

	public Product(String productName, int quantity) {
		this.productName = productName;
		this.quantity = quantity;
	}
	
	public Product(String productName, int quantity, String message) {
		this.productName = productName;
		this.quantity = quantity;
		this.message = message;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
