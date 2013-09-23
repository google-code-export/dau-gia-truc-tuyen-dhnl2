package com.entertainment.musicpage.dto;

public class Product {
	private String name;
	private String productCode;
	private String description;
	private int price;
	private String urlImage;
	
	
	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	

	public Product(String name, String productCode, String description,
			int price, String urlImage) {
		super();
		this.name = name;
		this.productCode = productCode;
		this.description = description;
		this.price = price;
		this.urlImage = urlImage;
	}

	public Product() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
