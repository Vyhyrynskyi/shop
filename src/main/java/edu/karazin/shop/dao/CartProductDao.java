package edu.karazin.shop.dao;

import edu.karazin.shop.entity.CartProduct;

public interface CartProductDao {
	public CartProduct getCartProduct (long productId, long cartId);
	public void addCartProduct (CartProduct cartProduct);
	public void updateCartProduct (CartProduct cartProduct);
	public void removeCartProduct (CartProduct cartProduct);
	public void removeAllProductsFromCart(long cartId);

}
