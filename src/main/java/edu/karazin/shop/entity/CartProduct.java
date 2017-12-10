package edu.karazin.shop.entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class CartProduct extends Product {
	@Id
	@GeneratedValue
	private long cartProductId;
	private long productId;
	private long purchasePrice;
	
	public CartProduct() {
		
	}
	
	public CartProduct(Product product, long purchasePrice) {
		super(product.getId(),product.getTitle(),product.getDescription());
		this.purchasePrice=purchasePrice;
	}
	
	public long getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
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
	
	//TODO implement this method
	/*@Override
	public boolean equals(Object obj){
		return false;
	}*/
	
}
