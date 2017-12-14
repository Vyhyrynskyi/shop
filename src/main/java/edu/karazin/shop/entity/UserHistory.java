package edu.karazin.shop.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserHistory {
	@Id
	private long cartId;
	private long userId;
	private Date purchaseDate;
	private long totalCost;
	private boolean isBuyed;

	public UserHistory() {
		
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPuchaseDate(Date puchaseDate) {
		this.purchaseDate = puchaseDate;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	public boolean isBuyed() {
		return isBuyed;
	}

	public void setBuyed(boolean isBuyed) {
		this.isBuyed = isBuyed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cartId ^ (cartId >>> 32));
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
		UserHistory other = (UserHistory) obj;
		if (cartId != other.cartId) {
			return false;
		}
		return true;
	}
	
	
}
