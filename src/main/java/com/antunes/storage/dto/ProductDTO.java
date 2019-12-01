package com.antunes.storage.dto;

import java.io.Serializable;

import com.antunes.storage.domain.Product;

public class ProductDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private double price;
	private String description;
	private Integer amount;
	private String category;
	private Integer categoryId;
	
	
	public ProductDTO(Integer id, String name, double price, String description, Integer amount, String category, Integer categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.amount = amount;
		this.category = category;
		this.categoryId = categoryId;
	}

	public ProductDTO() {}
	
	public ProductDTO(Product product) {
		this.name = product.getName();
		this.price = product.getPrice();
		this.description = product.getDescription();
		this.amount = product.getAmount();
		this.category = product.getCategory();
		this.categoryId = product.getCategoryId();
	}

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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
