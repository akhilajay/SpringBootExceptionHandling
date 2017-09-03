/**
 * 
 */
package com.akhil.Exceptionhandling.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.Exceptionhandling.entities.Product;
import com.akhil.Exceptionhandling.repository.ProductRepository;

/**
 * @author akhilajay
 *
 */
@Service("productService")
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product findProductByName(String name) {
		Product product = productRepository.findByproductName(name);
		if(product==null){
			throw new EntityNotFoundException();
		}
		
		return product;
	}

	public Product findProductByPrice(int price) {
		return productRepository.findByproductPrice(price);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product save(Product product) {
		return productRepository.saveAndFlush(product);
	}
}
