package com.cg.greatoutdoor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="great_outdoor_product")
public class Product {
	@Id
	@Column(name="product_Id")
	private int productId;
	
	@Column(name="price",length=5)
	private double price;
	
	@Column(name="colour",length=7)
	private String colour;
	
	@Column(name="dimension",length=10)
	private String dimension;
	
	@Column(name="specification",length=15)
	private String specification;
	
	@Column(name="maufacturer",length=10)
	private String manufacturer;
	
	@Column(name="quantity",length=3)
	private int quantity;
	
	@Column(name="product_Category",length=10)
	private int productCategory;
	
	@Column(name="product_Name",length=10)
	private String productName;
	

}
