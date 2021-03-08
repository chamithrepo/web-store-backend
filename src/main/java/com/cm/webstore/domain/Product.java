package com.cm.webstore.domain;

import static com.cm.webstore.configuration.Constants.Dal.CARTON_PRICE;
import static com.cm.webstore.configuration.Constants.Dal.LABOUR_TAX;
import static com.cm.webstore.configuration.Constants.Dal.PRODUCT_ID;
import static com.cm.webstore.configuration.Constants.Dal.PRODUCT_NAME;
import static com.cm.webstore.configuration.Constants.Dal.PRODUCT_TABLE_NAME;
import static com.cm.webstore.configuration.Constants.Dal.UNITS_PER_CARTON;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = PRODUCT_TABLE_NAME)
@Entity
public class Product extends BaseEntity {

	private UUID id;
	private String name;
	private BigDecimal cartonPrice;
	private BigDecimal unitsPerCarton;
	private BigDecimal labourTax;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = PRODUCT_ID, updatable = false, nullable = false)
	@JsonProperty(value = PRODUCT_ID)
//	@ApiModelProperty(value = "The dummy identifier, auto generated.")
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Column(name = PRODUCT_NAME, nullable = false)
	@JsonProperty(value = PRODUCT_NAME)
//	@ApiModelProperty(value = "The dummy identifier, auto generated.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = CARTON_PRICE, nullable = false)
	@JsonProperty(value = CARTON_PRICE)
//	@ApiModelProperty(value = "The dummy identifier, auto generated.")
	public BigDecimal getCartonPrice() {
		return cartonPrice;
	}

	public void setCartonPrice(BigDecimal cartonPrice) {
		this.cartonPrice = cartonPrice;
	}

	@Column(name = UNITS_PER_CARTON, nullable = false)
	@JsonProperty(value = UNITS_PER_CARTON)
//	@ApiModelProperty(value = "The dummy identifier, auto generated.")
	public BigDecimal getUnitsPerCarton() {
		return unitsPerCarton;
	}

	public void setUnitsPerCarton(BigDecimal unitsPerCarton) {
		this.unitsPerCarton = unitsPerCarton;
	}

	@Column(name = LABOUR_TAX, nullable = false)
	@JsonProperty(value = LABOUR_TAX)
//	@ApiModelProperty(value = "The dummy identifier, auto generated.")
	public BigDecimal getLabourTax() {
		return labourTax;
	}

	public void setLabourTax(BigDecimal labourTax) {
		this.labourTax = labourTax;
	}

}
