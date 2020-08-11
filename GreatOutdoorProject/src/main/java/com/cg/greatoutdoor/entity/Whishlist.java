package com.cg.greatoutdoor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="great_outdoor_whishlist")
public class Whishlist {
	@Id
	@Column(name="whishlist_Id")
	private int whishlist_id;
	
	@Column(name="product_Id",length = 10)
	private long productId;

	@ManyToOne
	@JoinColumn(name = "user_Id",referencedColumnName="user_Id")
	private User user;

	public int getWhishlist_id() {
		return whishlist_id;
	}

	public void setWhishlist_id(int whishlist_id) {
		this.whishlist_id = whishlist_id;
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
