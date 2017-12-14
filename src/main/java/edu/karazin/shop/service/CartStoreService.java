package edu.karazin.shop.service;

import java.util.List;

import edu.karazin.shop.entity.CartProduct;
import edu.karazin.shop.entity.User;

public interface CartStoreService {

	public long getCartId(User user);
	public long getCartIdForCurrentUser();
	public List<CartProduct> getCartProducts(long cartId);
	public void removeAllProductsFromCart(long cartId);
}
