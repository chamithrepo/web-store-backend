package com.cm.webstore.service.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.cm.webstore.domain.Product;


/**
 * @author Chamith_Madusanka
 *
 *
 * Price Strategy Three
 */
public class PriceStrategyThree implements PriceStrategy {

	public BigDecimal calculate(Product product, BigDecimal cartons, BigDecimal singleUnits) {

		BigDecimal unitPrice = product.getCartonPrice().multiply(new BigDecimal(1.3))
				.divide(product.getUnitsPerCarton());
		return unitPrice.multiply(singleUnits).setScale(2, RoundingMode.HALF_EVEN);
	}
}
