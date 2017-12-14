package edu.karazin.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.karazin.shop.entity.CartProduct;
import edu.karazin.shop.entity.CartProductPrimaryKey;

@Repository
public class CartProductDaoImpl implements CartProductDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public CartProduct getCartProduct(long cartId, long productId) {
		return em.find(CartProduct.class, new CartProductPrimaryKey(cartId, productId));
	}

	@Override
	public CartProduct saveCartProduct(CartProduct cartProduct) {
		if (!em.contains(cartProduct)) {
			return em.merge(cartProduct);
		} else {
			em.persist(cartProduct);
			return cartProduct;
		}
	}

	@Override
	public void removeCartProduct(CartProduct cartProduct) {
		em.remove(cartProduct);
	}

	@Override
	public void removeAllProductsFromCart(long cartId) {
		em.createQuery("delete from CartProduct where cartId = :cartId").setParameter("cartId", cartId);
	}

	@Override
	public List<CartProduct> getCartProductsByCartId(long cartId) {
		return em.createQuery("from CartProduct cp where cp.cartId is :cartId").setParameter("cartId", cartId).getResultList();
	}

}
