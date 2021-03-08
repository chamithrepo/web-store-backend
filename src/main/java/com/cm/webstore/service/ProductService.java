package com.cm.webstore.service;

import java.util.List;

import com.cm.webstore.domain.Product;

/**
 * @author Chamith_Madusanka
 *
 * Product Service
 */
public interface ProductService {

	
	/**
	 * Get Product
	 * 
	 * @param id
	 * @return
	 */
	Product getProduct(String id);
	
	
	/**
	 * Get Products
	 * 
	 * @return
	 */
	List<Product> getProducts();
}
