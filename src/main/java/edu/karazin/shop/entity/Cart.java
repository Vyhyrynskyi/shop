package edu.karazin.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private long cartId;
	private long cartProductId;
	private long productsAmount;
}
