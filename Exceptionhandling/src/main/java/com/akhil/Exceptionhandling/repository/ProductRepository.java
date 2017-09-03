/**
 * 
 */
package com.akhil.Exceptionhandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhil.Exceptionhandling.entities.Product;

/**
 * @author akhilajay
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findByproductName(String name);

	public Product findByproductPrice(int price);

}
