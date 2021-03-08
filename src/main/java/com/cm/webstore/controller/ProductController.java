package com.cm.webstore.controller;

import static com.cm.webstore.configuration.Constants.RequestMappings.PRODUCT;
import static com.cm.webstore.configuration.Constants.RequestMappings.PRODUCT_ROOT_PATH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.webstore.domain.Product;
import com.cm.webstore.exception.ResourceNotFoundException;
import com.cm.webstore.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author Chamith_Madusanka
 *
 * Product Controller
 */
@RestController
@RequestMapping(value = PRODUCT_ROOT_PATH)
@Validated
@Api(value = PRODUCT_ROOT_PATH)
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	public ProductController(final ProductService productService) {
		this.productService = productService;
	}

	
	/**
	 * Get a product by id
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@ApiOperation(value = "Get a product by id.")
	@GetMapping(value = PRODUCT)
	public @ResponseBody ResponseEntity<Product> getProduct(@PathVariable(value = "id") final String id)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(productService.getProduct(id));
	}

	
	/** 
	 * Get all products
	 * 
	 * @return
	 */
	@CrossOrigin
	@ApiOperation(value = "Get all products.")
	@GetMapping()
	public @ResponseBody ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getProducts());
	}
}
