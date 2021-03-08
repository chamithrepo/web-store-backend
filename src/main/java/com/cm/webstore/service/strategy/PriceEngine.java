package com.cm.webstore.service.strategy;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.cm.webstore.domain.Product;
import com.cm.webstore.dto.PriceResponseDto;
import com.cm.webstore.utils.ShaUtils;


/**
 * @author Chamith_Madusanka
 *
 * Price Engine
 */
public class PriceEngine {

	private final static String SECRET_KEY = "HKJLHKPOUYTYRFCJ76^*%^FVGUUOI";
	private PriceStrategy priceStrategy;

	public PriceEngine(PriceStrategy priceStrategy) {
		this.priceStrategy = priceStrategy;
	}

	/**
	 * @param product
	 * @param requestedUnits
	 * @return
	 */
	public PriceResponseDto execute(Product product, BigDecimal requestedUnits) {

		PriceResponseDto priceResponseDto = new PriceResponseDto();
		BigDecimal[] result = requestedUnits.divideAndRemainder(product.getUnitsPerCarton());
		BigDecimal cartons = result[0];
		BigDecimal singleUnits = result[1];

		priceResponseDto.setCartons(cartons.intValue());
		priceResponseDto.setSingleUnits(singleUnits.intValue());

		priceResponseDto.setPrice(priceStrategy.calculate(product, cartons, singleUnits));
		priceResponseDto.setProductId(product.getId().toString());
//		priceResponseDto.setPriceToken(generatePriceToken(cartons, singleUnits));

		return priceResponseDto;
	}

	/**
	 * Generate Price Token
	 *  
	 * @param cartons
	 * @param singleUnits
	 * @return
	 */
	private String generatePriceToken(BigDecimal cartons, BigDecimal singleUnits) {

		StringBuilder tokenString = new StringBuilder();
		final Charset UTF_8 = StandardCharsets.UTF_8;

		tokenString.append(cartons.toPlainString()).append(singleUnits.toPlainString()).append(SECRET_KEY);

		byte[] shaInBytes = ShaUtils.digest(tokenString.toString().getBytes(UTF_8));
		return ShaUtils.bytesToHex(shaInBytes);

	}

}
