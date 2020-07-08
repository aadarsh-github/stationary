/**
 * 
 */
package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.model.Product;
import com.example.demo.exception.ProductException;

/**
 * @author AAdarsh
 *
 */
@Service
public class ProductService {

	/**
	 * This function add new product.
	 * 
	 * @param name
	 * @param listOfProduct
	 * @return
	 */
	public Product addProduct(String name, int quantity, List<Product> listOfProduct) {

		boolean isProductFound = false;
		Product newProduct = null;
		for (Product product : listOfProduct) {
			if (name.equalsIgnoreCase(product.getProductName())) {
				isProductFound = true;
				product.setQuantity(product.getQuantity() + quantity);
				product.setMessage("Added "+quantity+" pieces successfully at " + LocalDateTime.now());
				newProduct = product;
				break;
			}
		}
		if (!isProductFound) {
			newProduct = new Product(name.toUpperCase(), quantity, "Added new product successfully at " + LocalDateTime.now());
			listOfProduct.add(newProduct);
		}
		return newProduct;
	}

	/**
	 * This function removes the product.
	 * 
	 * @param name
	 * @param listOfProduct
	 * @return
	 */
	public Object removeProduct(String name, List<Product> listOfProduct) {

		Object message = null;
		List<Product> newList = new LinkedList<>(listOfProduct);
		for (int i = 0; i < newList.size() - 1; i++) {
			if (newList.get(i).getProductName().equalsIgnoreCase(name)) {
				listOfProduct.remove(newList.get(i));
				message = "Product : \"" + name.toUpperCase() + "\" successfully removed at " + LocalDateTime.now();
				break;
			}
		}
		if (message == null)
			throw new ProductException("Product not found");
		return message;
	}

	/**
	 * This function is to buy product.
	 * 
	 * @param name
	 * @param listOfProduct
	 * @return
	 */
	public Object buyProduct(String name, int quantity, List<Product> listOfProduct) {

		Object purchasedProduct = null;
		for (Product product : listOfProduct) {
			if (name.equalsIgnoreCase(product.getProductName())) {
				if (product.getQuantity() - quantity >= 0) {
					product.setQuantity(product.getQuantity() - quantity);
					product.setMessage("Purchased "+quantity+" pieces");
					purchasedProduct = product;
					break;
				} else {
					int leftPieces = product.getQuantity() - 0;
					throw new ProductException("Only " + leftPieces + " pieces available");
				}
			}
		}
		if (purchasedProduct == null)
			throw new ProductException("Product not found");
		return purchasedProduct;
	}

}
