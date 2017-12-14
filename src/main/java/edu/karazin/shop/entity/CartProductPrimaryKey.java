package edu.karazin.shop.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class CartProductPrimaryKey implements Serializable {
	private static final long serialVersionUID = -5351482358110356655L;
	private long cartId;
	private long productId;

	public CartProductPrimaryKey() {

	}

	public CartProductPrimaryKey(long cartId, long productId) {
		this.cartId = cartId;
		this.productId = productId;
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
		CartProductPrimaryKey other = (CartProductPrimaryKey) obj;
		if (cartId != other.cartId) {
			return false;
		}
		if (productId != other.productId) {
			return false;
		}
		return true;
	}

}
