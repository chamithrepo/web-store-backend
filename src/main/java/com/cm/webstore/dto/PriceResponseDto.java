package com.cm.webstore.dto;

import java.math.BigDecimal;


/**
 * @author Chamith_Madusanka
 * 
 * Price Response Dto to capture request data
 *
 */
public class PriceResponseDto {

	Integer cartons;
	Integer singleUnits;
	BigDecimal price;
	String productId;
	String priceToken;

	public Integer getCartons() {
		return cartons;
	}

	public void setCartons(Integer cartons) {
		this.cartons = cartons;
	}

	public Integer getSingleUnits() {
		return singleUnits;
	}

	public void setSingleUnits(Integer singleUnits) {
		this.singleUnits = singleUnits;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPriceToken() {
		return priceToken;
	}

	public void setPriceToken(String priceToken) {
		this.priceToken = priceToken;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
