package edu.karazin.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import edu.karazin.shop.entity.CartProduct;

@Primary
@Component
public class InDatabaseCartStore implements CartStore{

	private CartStoreService cartStoreService;
	private CartProductService cartProductService;
	
	@Autowired
	public InDatabaseCartStore(CartStoreService cartStoreService, CartProductService cartProductService) {
		this.cartStoreService = cartStoreService;
		this.cartProductService = cartProductService;
	}

	@Override
	public List<CartProduct> getProducts() {
		return cartStoreService.getCartProducts(cartStoreService.getCartIdForCurrentUser());
	}

	@Override
	public void addProduct(CartProduct cartProduct, long purchaseAmount) {
		cartProductService.addCartProduct(cartProduct.getCartId(),cartProduct.getProductId(), purchaseAmount);
	}

	@Override
	public void removeProduct(CartProduct cartProduct) {
		cartProductService.removeCartProduct(cartProduct.getCartId(), cartProduct.getProductId());
	}

	@Override
	public void removeAllProducts() {
		cartStoreService.removeAllProductsFromCart(cartStoreService.getCartIdForCurrentUser());
	}

}
