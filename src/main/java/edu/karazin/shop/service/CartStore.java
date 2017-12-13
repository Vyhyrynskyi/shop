package edu.karazin.shop.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.karazin.shop.entity.Product;

@Component
public interface CartStore {

	List<Product> getProducts();

	void addProduct(Product prod);

	void removeProduct(Product prod);
}
