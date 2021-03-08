package com.cm.webstore.controller;

import static com.cm.webstore.configuration.Constants.RequestMappings.PRICE_FOR_PRODCUCT;
import static com.cm.webstore.configuration.Constants.RequestMappings.PRICE_LIST_FOR_PRODUCT;
import static com.cm.webstore.configuration.Constants.RequestMappings.PRICE_ROOT_PATH;

import java.math.BigDecimal;
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

import com.cm.webstore.dto.PriceResponseDto;
import com.cm.webstore.exception.ResourceNotFoundException;
import com.cm.webstore.service.PriceService;
import com.cm.webstore.validators.ValidUuid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author Chamith_Madusanka
 * 
 * Price Controller
 *
 */
@RestController
@RequestMapping(value = PRICE_ROOT_PATH)
@Validated
@Api(value = PRICE_ROOT_PATH)
public class PriceController {

	@Autowired
	private PriceService priceService;

	@Autowired
	public PriceController(final PriceService priceService) {
		this.priceService = priceService;
	}

	
	/**
	 * Get price for a requested product
	 * 
	 * @param productId
	 * @param units
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@CrossOrigin
	@ApiOperation(value = "Get price for a requested product")
	@GetMapping(value = PRICE_FOR_PRODCUCT)
	public @ResponseBody ResponseEntity<PriceResponseDto> getPriceForProduct(
			@PathVariable(value = "id") @ValidUuid final String productId,
			@PathVariable(value = "units") final int units) throws ResourceNotFoundException {
		PriceResponseDto priceResponseDto = null;
		priceResponseDto = priceService.getPriceforProduct(productId, new BigDecimal(units).setScale(2));
		return ResponseEntity.ok(priceResponseDto);
	}

	
	/**
	 * Get price list for a specific product.
	 * 
	 * @param productId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@CrossOrigin
	@ApiOperation(value = "Get price list for a specific product.")
	@GetMapping(value = PRICE_LIST_FOR_PRODUCT)
	public @ResponseBody ResponseEntity<List<PriceResponseDto>> getPriceListForProduct(
			@PathVariable(value = "id") @ValidUuid final String productId) throws ResourceNotFoundException {
		List<PriceResponseDto> priceList = null;
		priceList = priceService.getPriceListforProduct(productId, new BigDecimal(50));
		return ResponseEntity.ok(priceList);
	}
}
