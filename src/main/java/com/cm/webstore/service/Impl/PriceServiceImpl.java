package com.cm.webstore.service.Impl;

import static com.cm.webstore.configuration.Constants.Exceptions.PRODUCT_NOT_FOUND;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.webstore.domain.Product;
import com.cm.webstore.dto.PriceResponseDto;
import com.cm.webstore.exception.ResourceNotFoundException;
import com.cm.webstore.persister.ProductRepository;
import com.cm.webstore.service.PriceService;
import com.cm.webstore.service.strategy.PriceEngine;
import com.cm.webstore.service.strategy.PriceStrategyOne;
import com.cm.webstore.service.strategy.PriceStrategyThree;
import com.cm.webstore.service.strategy.PriceStrategyTwo;



/**
 * @author Chamith_Madusanka
 * 
 * Price Service Impl
 *
 */
@Service
public class PriceServiceImpl implements PriceService {

	private final ProductRepository productRepository;

	@Autowired
	public PriceServiceImpl(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	
	public PriceResponseDto getPriceforProduct(String productId, BigDecimal units) throws ResourceNotFoundException {

		if (units.compareTo(BigDecimal.ZERO) <= 0)
			throw new IllegalArgumentException();

		return this.calulatePrice(productRepository.findById(UUID.fromString(productId))
				.orElseThrow(() -> new ResourceNotFoundException(PRODUCT_NOT_FOUND)), units);
	}

	public List<PriceResponseDto> getPriceListforProduct(String productId, BigDecimal units) {

		Product product = productRepository.findById(UUID.fromString(productId))
				.orElseThrow(() -> new ResourceNotFoundException(PRODUCT_NOT_FOUND));

		List<PriceResponseDto> priceList = new ArrayList<>();

		for (int i = 1; i <= units.intValue(); i++) {
			priceList.add(this.calulatePrice(product, new BigDecimal(i).setScale(2)));
		}

		return priceList;

	}

	private PriceResponseDto calulatePrice(Product product, BigDecimal requestedUnits) {

		PriceEngine priceEngine = null;
		if (product.getUnitsPerCarton().equals(requestedUnits)) {
			priceEngine = new PriceEngine(new PriceStrategyOne());
		} else if (product.getUnitsPerCarton().compareTo(requestedUnits) < 0) {
			priceEngine = new PriceEngine(new PriceStrategyTwo());
		} else {
			priceEngine = new PriceEngine(new PriceStrategyThree());
		}

		return priceEngine.execute(product, requestedUnits);

	}
}
