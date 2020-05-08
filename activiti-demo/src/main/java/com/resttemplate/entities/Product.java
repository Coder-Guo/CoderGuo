package com.resttemplate.entities;

import java.math.BigDecimal;

public class Product {

	private Integer id;
	private String name;
	private BigDecimal price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Product() {
		
	}
	
	public Product(Integer id, String name, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [编号=" + id + ", 名称=" + name + ", 价格=" + price + "]";
	}
	
}