package edu.karazin.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
//@Table(name = "CartProduct", uniqueConstraints = { @UniqueConstraint(columnNames = { "cartId", "productId" }) })
@IdClass(CartProductPrimaryKey.class)
public class CartProduct {
	@Id
	private long cartId;
	@Id
	private long productId;
	private long purchasePrice;
	private long purchaseNumber;

	public CartProduct() {

	}
	public CartProduct(long cartId, long productId) {
		this.cartId = cartId;
		this.productId = productId;
	}
	
	public CartProduct(long cartId, long productId, long purchaseNumber) {
		this.cartId = cartId;
		this.productId = productId;
		this.purchaseNumber = purchaseNumber;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cartId ^ (cartId >>> 32));
		result = prime * result + (int) (productId ^ (productId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CartProduct other = (CartProduct) obj;
		if (cartId != other.cartId) {
			return false;
		}
		if (productId != other.productId) {
			return false;
		}
		return true;
	}


}
