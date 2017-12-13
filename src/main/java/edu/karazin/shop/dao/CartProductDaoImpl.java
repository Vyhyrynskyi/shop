package edu.karazin.shop.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.karazin.shop.entity.CartProduct;

public class CartProductDaoImpl implements CartProductDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public CartProduct getCartProduct(long productId, long cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCartProduct(CartProduct cartProduct) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCartProduct(CartProduct cartProduct) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCartProduct(CartProduct cartProduct) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAllProductsFromCart(long cartId) {
		// TODO Auto-generated method stub
		
	}

}
