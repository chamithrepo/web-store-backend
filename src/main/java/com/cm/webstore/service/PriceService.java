package com.cm.webstore.service;

import java.math.BigDecimal;
import java.util.List;

import com.cm.webstore.dto.PriceResponseDto;


/**
 * @author Chamith_Madusanka
 *
 * Price Service
 */
public interface PriceService {

	/**
	 * Get Price for Product
	 * 
	 * @param productId
	 * @param units
	 * @return
	 */
	PriceResponseDto getPriceforProduct(String productId, BigDecimal units);

	
	/**
	 * Get Price List for Product
	 * 
	 * @param productId
	 * @param units
	 * @return
	 */
	List<PriceResponseDto> getPriceListforProduct(String productId, BigDecimal units);

}
