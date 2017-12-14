package edu.karazin.shop.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.karazin.shop.entity.CartProduct;
import edu.karazin.shop.entity.Product;

@Component
public interface CartStore {

	List<CartProduct> getProducts();

	void addProduct(CartProduct prod);

	void removeProduct(CartProduct prod);
	void removeAllProducts();
}
