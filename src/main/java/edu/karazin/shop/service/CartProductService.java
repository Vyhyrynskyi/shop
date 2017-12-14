package edu.karazin.shop.service;

import edu.karazin.shop.entity.CartProduct;

public interface CartProductService {
	public CartProduct getCartProduct(long cartId, long productId);

	/**
	 * Adds product to the cart.
	 * 
	 * </br>
	 * If products already exists in the cart, adds this {@code purchaseNumber} to
	 * {@code purchaseNumber} of that product in the cart. </br>
	 * If total purchaseNumber of this product (after adding to the cart) is greater
	 * than product balance,</br>
	 * sets {@code purchaseAmount} equals to {@code productBalance} (maximum number
	 * of products, that available to buy)</br>
	 * and return {@code false}.
	 * 
	 * @param productId
	 * @param cartId
	 *            id of the cart
	 * @param purchaseNumber
	 *            number of products to add to the cart
	 * @return false, if total number of product to purchase is greater than product
	 *         balance, otherwise, true.
	 */
	public boolean addCartProduct(long cartId, long productId, long purchaseNumber);

	public void removeCartProduct(long cartId, long productId);

	public void refreshPrice(CartProduct cartProduct);
}
