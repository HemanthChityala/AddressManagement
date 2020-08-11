package com.cg.greatoutdoor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="great_outdoor_cart")
public class Cart {
	@Id
	@Column(name="cart_Id")
	private int cart_Id;
	
	@Column(name="product_Id",length = 10)
	private long productId;

	@ManyToOne
	@JoinColumn(name = "user_Id",referencedColumnName="user_Id")
	private User user;

	public int getCart_Id() {
		return cart_Id;
	}

	public void setCart_Id(int cart_Id) {
		this.cart_Id = cart_Id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
