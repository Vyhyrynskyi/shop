package edu.karazin.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import edu.karazin.shop.dao.UserHistoryDao;
import edu.karazin.shop.dao.UserRepository;
import edu.karazin.shop.entity.User;
import edu.karazin.shop.entity.UserHistory;

@Service
public class CartStoreServiceImpl implements CartStoreService {

	//private long cartId;
	private UserRepository userRepository;
	private UserHistoryDao userHistoryDao;
	
	@Autowired
	public CartStoreServiceImpl(UserRepository userRepository, UserHistoryDao userHistoryDao) {
		this.userRepository = userRepository;
		this.userHistoryDao = userHistoryDao;
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

}
