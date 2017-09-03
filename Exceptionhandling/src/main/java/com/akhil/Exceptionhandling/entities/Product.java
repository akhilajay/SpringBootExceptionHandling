/**
 * 
 */
package com.akhil.Exceptionhandling.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author akhilajay
 *
 */
@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String productName;
	private int productPrice;
	
/*	public Product(int id,String productName,int productPrice){
		this.id=id;
		this.productName=productName;
		this.productPrice=productPrice;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
}
