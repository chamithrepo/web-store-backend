package com.cm.webstore.service.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.cm.webstore.domain.Product;


/**
 * @author Chamith_Madusanka
 *
 * Price Strategy Two
 */
public class PriceStrategyTwo implements PriceStrategy {

	public BigDecimal calculate(Product product, BigDecimal cartons, BigDecimal singleUnits) {

		BigDecimal cartonsPrice = BigDecimal.ZERO;
		BigDecimal singleUnitsPrice = BigDecimal.ZERO;

		if (cartons.compareTo(new BigDecimal(3)) > 0) {

			BigDecimal discountedCartonPrice = product.getCartonPrice().multiply(new BigDecimal(0.1));
			cartonsPrice = product.getCartonPrice().subtract(discountedCartonPrice).multiply(cartons);
			singleUnitsPrice = this.getSingleUnitPrice(discountedCartonPrice, product.getUnitsPerCarton())
					.multiply(singleUnits);

		} else {
			cartonsPrice = product.getCartonPrice().multiply(cartons);
			singleUnitsPrice = getSingleUnitPrice(product.getCartonPrice(), product.getUnitsPerCarton())
					.multiply(singleUnits);
		}

		return cartonsPrice.add(singleUnitsPrice).setScale(2, RoundingMode.HALF_EVEN);

	}

	private BigDecimal getSingleUnitPrice(BigDecimal cartonPrice, BigDecimal unitsPerCarton) {
		return cartonPrice.multiply(new BigDecimal(1.3)).divide(unitsPerCarton);
	}

}
