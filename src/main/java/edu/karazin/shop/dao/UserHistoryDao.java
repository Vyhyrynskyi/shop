package edu.karazin.shop.dao;

import edu.karazin.shop.entity.User;
import edu.karazin.shop.entity.UserHistory;

public interface UserHistoryDao {

	public UserHistory getNewCartId(User user);
	public UserHistory getLatestUserHistory(User user);
	public UserHistory saveUserHistory(UserHistory userHistory);
}
