package edu.karazin.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.karazin.shop.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Product findById(Long id) {
		return em.find(Product.class, id);
	}

	@Override
	public List<Product> findByText(String searchText) {
		return em.createQuery("from Product p where p.title like :text or p.description like :text and p.isEnabled is true", Product.class)
				.setParameter("text", "%" + searchText + "%")
				.getResultList();
	}

	@Override
	public List<Product> findAll() {
		return em.createQuery("from Product", Product.class)
				.getResultList();
	}

	@Override
	public List<Product> findAllEnabled() {
		return em.createQuery("from Product p where p.isEnabled is true", Product.class)
				.getResultList();
	}

	@Override
	public Product save(Product prod) {
		if (!em.contains(prod)) {
			return em.merge(prod);
		} else {
			em.persist(prod);
			return prod;
		}
	}

	@Override
	public void disable(Long id) {
		Product product = findById(id);
		product.setIsEnabled(false);
		em.refresh(product);
	}

}
