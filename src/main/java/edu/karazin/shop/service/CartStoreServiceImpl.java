package edu.karazin.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import edu.karazin.shop.dao.CartProductDao;
import edu.karazin.shop.dao.UserHistoryDao;
import edu.karazin.shop.dao.UserRepository;
import edu.karazin.shop.entity.CartProduct;
import edu.karazin.shop.entity.User;
import edu.karazin.shop.entity.UserHistory;

@Service
public class CartStoreServiceImpl implements CartStoreService {

	//private long cartId;
	private UserRepository userRepository;
	private UserHistoryDao userHistoryDao;
	private CartProductDao cartProductDao;
	
	@Autowired
	public CartStoreServiceImpl(UserRepository userRepository, UserHistoryDao userHistoryDao, CartProductDao cartProductDao) {
		this.userRepository = userRepository;
		this.userHistoryDao = userHistoryDao;
		this.cartProductDao = cartProductDao;
	}
	
	@Override
	public long getCartId(User user) {
		UserHistory userHistory = userHistoryDao.getLatestUserHistory(user);
		if(userHistory.isBuyed()) {
			userHistory = userHistoryDao.getNewCartId(user);
		} 
		return userHistory.getCartId();
	}

	@Override
	public long getCartIdForCurrentUser() {
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByLogin(login);
		return getCartId(user);
	}

	@Override
	public List<CartProduct> getCartProducts(long cartId) {
		return cartProductDao.getCartProductsByCartId(cartId);
	}

	@Override
	public void removeAllProductsFromCart(long cartId) {
		cartProductDao.removeAllProductsFromCart(cartId);
	}

}
