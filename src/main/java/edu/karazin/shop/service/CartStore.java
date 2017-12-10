package edu.karazin.shop.service;

import java.util.List;

import edu.karazin.shop.entity.CartProduct;
import edu.karazin.shop.entity.Product;

public interface CartStore {

	List<Product> getProducts();

	void addProduct(Product prod);

	void removeProduct(Product prod);
}
