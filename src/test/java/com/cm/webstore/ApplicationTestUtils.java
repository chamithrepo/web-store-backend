package com.cm.webstore;

import java.math.BigDecimal;
import java.util.UUID;

import com.cm.webstore.domain.Product;


/**
 * @author Chamith_Madusanka
 *
 * Application Test Utils to support Unit testing
 */
public class ApplicationTestUtils {

	public static Product getProduct() {
		Product product = new Product();
		product.setId(UUID.fromString("8dd5f315-9788-4d00-87bb-10eed9eff566"));
		product.setName("Penguin-ears");
		product.setCartonPrice(new BigDecimal(175));
		product.setUnitsPerCarton(new BigDecimal(20));
		return product;
	}

}
