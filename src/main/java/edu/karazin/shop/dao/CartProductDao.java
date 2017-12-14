package edu.karazin.shop.dao;

import java.util.List;

import edu.karazin.shop.entity.CartProduct;

public interface CartProductDao {
	public CartProduct getCartProduct (long cartId, long productId);
	public CartProduct saveCartProduct (CartProduct cartProduct);
	public List<CartProduct> getCartProductsByCartId(long cartId);
	public void removeCartProduct (CartProduct cartProduct);
	public void removeAllProductsFromCart(long cartId);

}
