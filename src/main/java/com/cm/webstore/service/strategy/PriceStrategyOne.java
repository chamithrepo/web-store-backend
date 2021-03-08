package com.cm.webstore.service.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.cm.webstore.domain.Product;


/**
 * @author Chamith_Madusanka
 *
 */
public class PriceStrategyOne implements PriceStrategy {

	
	public BigDecimal calculate(Product product, BigDecimal cartons, BigDecimal singleUnits) {
		return product.getCartonPrice().setScale(2, RoundingMode.HALF_EVEN);
	}
}
