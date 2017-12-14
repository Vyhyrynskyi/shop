package edu.karazin.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import edu.karazin.shop.entity.CartProduct;
import edu.karazin.shop.entity.Product;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
public class InMemoryCartStore implements CartStore{

	private final List<CartProduct> products = new ArrayList<>();

	@Override
	public List<CartProduct> getProducts() {
		return products;
	}

	@Override
	public void addProduct(CartProduct prod) {
		products.add(prod);
	}

	@Override
	public void removeProduct(CartProduct prod) {
		products.remove(prod);
	}

	@Override
	public void removeAllProducts() {
		products.clear();
	}
}
