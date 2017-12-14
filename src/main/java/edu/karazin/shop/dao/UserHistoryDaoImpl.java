package edu.karazin.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import edu.karazin.shop.entity.User;
import edu.karazin.shop.entity.UserHistory;
import edu.karazin.shop.web.ProductListController;

@Repository
public class UserHistoryDaoImpl implements UserHistoryDao {

	@PersistenceContext
	private EntityManager em;

	private static final Logger log = LoggerFactory.getLogger(ProductListController.class);
	// XXX I`m not sure that this works fine.
	@Override
	public UserHistory getLatestUserHistory(User user) {
		UserHistory userHistory = new UserHistory();
		log.info("User id:" + user.getId());
		try{userHistory = (UserHistory) em.createQuery(
				"select uh from UserHistory uh where uh.userId is :userId order by cartId desc")
				.setParameter("userId", user.getId()).getSingleResult();
		//return userHistoryList.get(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userHistory;
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
