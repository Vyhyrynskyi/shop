package edu.karazin.shop.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserHistory {
	@Id
	public long cartId;
	public long userId;
	public Date puchaseDate;
	public long totalCost;

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

	public Date getPuchaseDate() {
		return puchaseDate;
	}

	public void setPuchaseDate(Date puchaseDate) {
		this.puchaseDate = puchaseDate;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	
	//TODO implement eqauls() and hashCode() methods
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