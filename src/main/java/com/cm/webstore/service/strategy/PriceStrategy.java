package com.cm.webstore.service.strategy;

import java.math.BigDecimal;

import com.cm.webstore.domain.Product;


/**
 * @author Chamith_Madusanka
 *
 * Price Strategy
 */
public interface PriceStrategy {

	 BigDecimal calculate(Product product, BigDecimal cartons, BigDecimal singleUnits);
}
