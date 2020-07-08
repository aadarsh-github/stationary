/**
 * 
 */
package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.model.Product;
import com.example.demo.service.ProductService;

/**
 * @author AAdarsh
 *
 */
@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	List<Product> listOfProduct;

	@GetMapping(value = "")
	public List<Product> listAllProducts() {

		return this.getListOfProduct();
	}

	@GetMapping("/add/{name}")
	public Product addProduct(@PathVariable String name, @RequestParam(name = "quantity", required = false) int quantity) {

		return this.productService.addProduct(name, quantity, this.getListOfProduct());
	}

	@GetMapping("/remove/{name}")
	public Object removeProduct(@PathVariable String name) {

		return this.productService.removeProduct(name, this.getListOfProduct());
	}

	@GetMapping("/buy/{name}")
	public Object purchaseProduct(@PathVariable String name, @RequestParam(name = "quantity", required = false) int quantity) {

		return this.productService.buyProduct(name, quantity, this.getListOfProduct());
	}
	
	/**
	 * @return the listOfProduct
	 */
	public List<Product> getListOfProduct() {

		if (listOfProduct == null) {
			listOfProduct = new LinkedList<>();
			listOfProduct.add(new Product("PEN", 10, "Available"));
			listOfProduct.add(new Product("BOOK", 30, "Available"));
			listOfProduct.add(new Product("BOX", 25, "Available"));
		} else {
			listOfProduct.forEach(n -> n.setMessage((n.getQuantity()>0? "Available" : "Not Available")));
		}
		return listOfProduct;
	}

	/**
	 * @param listOfProduct the listOfProduct to set
	 */
	public void setListOfProduct(List<Product> listOfProduct) {
		this.listOfProduct = listOfProduct;
	}

}
