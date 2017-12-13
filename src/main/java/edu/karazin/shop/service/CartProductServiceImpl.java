package edu.karazin.shop.service;

import edu.karazin.shop.dao.CartProductDao;
import edu.karazin.shop.dao.CartProductDaoImpl;
import edu.karazin.shop.entity.CartProduct;

public class CartProductServiceImpl implements CartProductService {

	private CartProductDao dao = new CartProductDaoImpl();
	@Override
	public CartProduct getCartProduct(long productId, long cartId) {
		return dao.getCartProduct(productId, cartId);
	}

	@Override
	public boolean addCartProduct(long productId, long cartId, long purchaseNumber) {
		CartProduct cartProduct = dao.getCartProduct(productId, cartId);
		return false;
	}

	@Override
	public void removeCartProduct(long productId, long cartId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshPrice(long productId, long cartId) {
		// TODO Auto-generated method stub

	}

}
