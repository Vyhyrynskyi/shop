package edu.karazin.shop.service;

import java.util.List;

import edu.karazin.shop.entity.Product;

public interface ProductService {

	Product getProduct(Long id);

	List<Product> searchProducts(String searchText);

	Long addProduct(Product prod);

	void updateProduct(Product prod);

	void removeProduct(Long id);
}
