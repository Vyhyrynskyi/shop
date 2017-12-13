package edu.karazin.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
    @GeneratedValue
	private Long id;
	private String title;
	private String description;
	//TODO image blob into DB
	private byte[] image;
	private String imageMimeType;
	private long cost;
	private int balance;
	//TODO Products are not removed, they are only turned off.
	private boolean isEnabled = true;

	public Product() {
	}
	
	public Product(Long id, String title, String description) {
		this(id, title, description, null, null, 0L, 0);
	}
	
	public Product(Long id, String title, String description, byte[] image, String imageMimeType, long cost, int balance) {
		this(id, title, description, image, imageMimeType, cost, balance, true);
	}
	
	public Product(Long id, String title, String description, byte[] image, String imageMimeType, long cost, int balance, boolean isEnabled) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.imageMimeType = imageMimeType;
		this.cost = cost;
		this.balance = balance;
		this.isEnabled = isEnabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageMimeType() {
		return imageMimeType;
	}

	public void setImageMimeType(String imageMimeType) {
		this.imageMimeType = imageMimeType;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}


	public boolean isEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null || !id.equals(other.id)) {
			return false;
		} else {
			return true;
		}
	}
	
}
