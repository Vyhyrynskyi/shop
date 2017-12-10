package edu.karazin.shop.dao;

import java.util.List;

import edu.karazin.shop.entity.Product;

public interface ProductDao {

	Product findById(Long id);

	List<Product> findByText(String searchText);

	List<Product> findAll();

	Product save(Product prod);

	void delete(Long id);
}
