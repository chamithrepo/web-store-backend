package com.cm.webstore.service.Impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cm.webstore.ApplicationTestUtils;
import com.cm.webstore.domain.Product;
import com.cm.webstore.dto.PriceResponseDto;
import com.cm.webstore.exception.ResourceNotFoundException;
import com.cm.webstore.persister.ProductRepository;

/**
 * @author Chamith_Madusanka
 *
 * Price Service Impl Test
 * 
 */
public class PriceServiceImplTest {

	@InjectMocks
	private PriceServiceImpl priceService;

	@Mock
	ProductRepository productRepository;

	private Product product;

	private static String PRODUCT_ID = "8dd5f315-9788-4d00-87bb-10eed9eff56";

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		product = ApplicationTestUtils.getProduct();
	}

	/**
	 * 
	 */
	@Test
	public void shouldReturnCartonPriceWhenRequestedUnitsEqualToSingleCarton() {
		BigDecimal oneCartonPrice = new BigDecimal("175.00");
		BigDecimal unitsRequested = new BigDecimal(20);

		doReturn(Optional.of(product)).when(productRepository).findById(UUID.fromString(PRODUCT_ID));
		BigDecimal actualPrice = priceService.getPriceforProduct(PRODUCT_ID, unitsRequested).getPrice();
		assertEquals(oneCartonPrice, actualPrice);
	}

	@Test
	public void shouldReturnCartonsPriceWhenRequestedUnitsEqualToMultipleCartons() {
		BigDecimal threeCartonsPrice = new BigDecimal("350.00");
		BigDecimal unitsRequested = new BigDecimal(40);
		doReturn(Optional.of(product)).when(productRepository).findById(UUID.fromString(PRODUCT_ID));
		BigDecimal actualPrice = priceService.getPriceforProduct(PRODUCT_ID, unitsRequested).getPrice();
		assertEquals(threeCartonsPrice, actualPrice);
	}

	@Test
	public void shouldReturnCartonsPricePlusSingleUnitsPriceWhenRequestedUnitsGreaterThanMultipleCartons() {
		BigDecimal cartonPricePlusSingleUnitsPrice = new BigDecimal("231.88");
		BigDecimal unitsRequested = new BigDecimal(25);
		doReturn(Optional.of(product)).when(productRepository).findById(UUID.fromString(PRODUCT_ID));
		BigDecimal actualPrice = priceService.getPriceforProduct(PRODUCT_ID, unitsRequested).getPrice();
		assertEquals(cartonPricePlusSingleUnitsPrice, actualPrice);
	}

	@Test
	public void shouldReturnSingleUnitsPriceWhenRequestedUnitsLessSingleCarton() {
		BigDecimal singleUnitsPrice = new BigDecimal("56.88");
		BigDecimal unitsRequested = new BigDecimal(5);
		doReturn(Optional.of(product)).when(productRepository).findById(UUID.fromString(PRODUCT_ID));
		BigDecimal actualPrice = priceService.getPriceforProduct(PRODUCT_ID, unitsRequested).getPrice();
		assertEquals(singleUnitsPrice, actualPrice);
	}

	@Test
	public void shouldReturnDiscountedPriceWhenGettingThreeOrMoreCartons() {
		BigDecimal singleUnitsPrice = new BigDecimal("630.00");
		BigDecimal unitsRequested = new BigDecimal(80);
		doReturn(Optional.of(product)).when(productRepository).findById(UUID.fromString(PRODUCT_ID));
		BigDecimal actualPrice = priceService.getPriceforProduct(PRODUCT_ID, unitsRequested).getPrice();
		assertEquals(singleUnitsPrice, actualPrice);
	}

	@Test
	public void shouldReturnPriceListForRequestedProduct() {
		BigDecimal unitsRequested = new BigDecimal(50);
		doReturn(Optional.of(product)).when(productRepository).findById(UUID.fromString(PRODUCT_ID));
		List<PriceResponseDto> list = priceService.getPriceListforProduct(PRODUCT_ID, unitsRequested);
		assertEquals(50, list.size());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void shouldThrowResourceNotFoundExceptionWhenProductIsNotFound() {
		BigDecimal unitsRequested = new BigDecimal(80);
		doReturn(Optional.ofNullable(null)).when(productRepository).findById(UUID.fromString(PRODUCT_ID));
		priceService.getPriceforProduct(PRODUCT_ID, unitsRequested).getPrice();
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenWhenRequstedUnitsLessThanOrEqualsToZero() {
		BigDecimal unitsRequested = new BigDecimal(-1);
		doReturn(Optional.ofNullable(null)).when(productRepository).findById(UUID.fromString(PRODUCT_ID));
		priceService.getPriceforProduct(PRODUCT_ID, unitsRequested).getPrice();
	}

}
