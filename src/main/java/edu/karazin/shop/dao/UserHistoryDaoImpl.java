package edu.karazin.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.karazin.shop.entity.User;
import edu.karazin.shop.entity.UserHistory;

@Repository
public class UserHistoryDaoImpl implements UserHistoryDao {

	@PersistenceContext
	private EntityManager em;
	//XXX I`m not sure that this works fine.
	@Override
	public UserHistory getLatestUserHistory(User user) {
		UserHistory userHistory = new UserHistory();
		List<UserHistory> userHistoryList = em.createQuery("from UserHistory where userId = :userId order by cartId desc limit 1")
				.setParameter("userId", user.getId()).getResultList();
		return userHistoryList.get(0);
	}

	@Override
	public UserHistory getNewCartId(User user) {
		UserHistory userHistory = new UserHistory();
		userHistory.setUserId(user.getId());
		em.persist(userHistory);
		return userHistory;
	}

	@Override
	public UserHistory saveUserHistory(UserHistory userHistory) {
		if (!em.contains(userHistory)) {
			return em.merge(userHistory);
		} else {
			em.persist(userHistory);
			return userHistory;
		}
	}

}
