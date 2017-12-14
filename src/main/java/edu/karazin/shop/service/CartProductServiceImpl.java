package edu.karazin.shop.service;

import org.springframework.stereotype.Service;

import edu.karazin.shop.dao.CartProductDao;
import edu.karazin.shop.dao.CartProductDaoImpl;
import edu.karazin.shop.dao.ProductDao;
import edu.karazin.shop.dao.ProductDaoImpl;
import edu.karazin.shop.entity.CartProduct;
import edu.karazin.shop.entity.Product;


@Service
public class CartProductServiceImpl implements CartProductService {

	private CartProductDao dao = new CartProductDaoImpl();
	private ProductDao productDao = new ProductDaoImpl();
	@Override
	public CartProduct getCartProduct(long cartId, long productId) {
		return dao.getCartProduct(cartId, productId);
	}

	@Override
	public boolean addCartProduct(long cartId, long productId, long purchaseNumber) {
		CartProduct cartProduct = dao.getCartProduct(cartId, productId);
		if(cartProduct == null) {
			cartProduct = new CartProduct(cartId, productId, purchaseNumber);
			refreshPrice(cartProduct);
			return checkProductBalance(cartId, productId, purchaseNumber);
		} else {
			long totalPurchaseNumber = cartProduct.getPurchaseNumber();
			totalPurchaseNumber += purchaseNumber;
			cartProduct.setPurchaseNumber(totalPurchaseNumber);
			refreshPrice(cartProduct);
			return checkProductBalance(cartProduct);
		}
	}

	private boolean checkProductBalance(long cartId, long productId, long purchaseNumber) {
		CartProduct cartProduct = new CartProduct(cartId, productId, purchaseNumber);
		return checkProductBalance(cartProduct);
	}

	private boolean checkProductBalance(CartProduct cartProduct) {
		Product product = productDao.findById(cartProduct.getProductId());
		if(cartProduct.getPurchaseNumber()> product.getBalance()) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void removeCartProduct(long cartId, long productId) {
		dao.removeCartProduct(new CartProduct(cartId, productId));
	}

	@Override
	public void refreshPrice(CartProduct cartProduct) {
		Product product = productDao.findById(cartProduct.getProductId());
		cartProduct.setPurchasePrice(product.getCost());
	}

}
