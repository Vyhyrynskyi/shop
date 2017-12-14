package edu.karazin.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import edu.karazin.shop.entity.CartProduct;
import edu.karazin.shop.entity.Product;
@Component
public class InDatabaseCartStore {

	private CartStoreService cartStoreService;
	
	@Autowired
	public InDatabaseCartStore(CartStoreService cartStoreService) {
		this.cartStoreService = cartStoreService;
	}
	
	public List<CartProduct> getCartProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addCartProduct(Product prod) {
		// TODO Auto-generated method stub

	}

	
	public void removeCartProduct(Product prod) {
		// TODO Auto-generated method stub

	}

}
