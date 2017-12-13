package edu.karazin.shop.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CartProduct", uniqueConstraints = { @UniqueConstraint(columnNames = { "cartId", "productId" }) })
public class CartProduct {
	@Id
	@GeneratedValue
	@Column (name= "cartId", unique= false)
	private long cartId;
	//@Id
	private long productId;
	private long purchasePrice;
	private long purchaseNumber;

	public CartProduct() {

	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(long purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public long getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(long purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	// TODO implement equals() and hashCode() methods
	/*
	 * @Override public boolean equals(Object obj){ return false; }
	 */

}
