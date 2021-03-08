package com.cm.webstore.service.Impl;

import static com.cm.webstore.configuration.Constants.Exceptions.PRODUCT_NOT_FOUND;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.webstore.domain.Product;
import com.cm.webstore.exception.ResourceNotFoundException;
import com.cm.webstore.persister.ProductRepository;
import com.cm.webstore.service.ProductService;

/**
 * @author Chamith_Madusanka
 * 
 * Product Service Impl 
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product getProduct(String id) {
		return productRepository.findById(UUID.fromString(id))
				.orElseThrow(() -> new ResourceNotFoundException(PRODUCT_NOT_FOUND));
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}
}
