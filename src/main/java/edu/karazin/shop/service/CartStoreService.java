package edu.karazin.shop.service;

import edu.karazin.shop.entity.User;

public interface CartStoreService {

	public long getCartId(User user);
	public long getCartIdForCurrentUser();
}
