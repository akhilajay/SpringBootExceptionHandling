/**
 * 
 */
package com.akhil.Exceptionhandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.Exceptionhandling.entities.Product;
import com.akhil.Exceptionhandling.services.ProductService;

/**
 * @author akhilajay
 *
 */
@RestController
@RequestMapping("/demo")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product savedProduct = productService.save(product);
		
		return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
	}
	
	@GetMapping("/product/name/{productName}")
	public ResponseEntity<Product> findProducByName(@PathVariable String productName){
		Product searchedProduct = productService.findProductByName(productName);
		return new ResponseEntity<Product>(searchedProduct, HttpStatus.OK); 
	}
	
	@GetMapping("/product/price/{productPrice}")
	public ResponseEntity<Product> findProducByName(@PathVariable int productPrice){
		Product searchedProduct = productService.findProductByPrice(productPrice);
		return new ResponseEntity<Product>(searchedProduct, HttpStatus.OK); 
	}

}
