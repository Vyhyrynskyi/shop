package edu.karazin.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.karazin.shop.entity.CartProduct;
import edu.karazin.shop.entity.Product;
import edu.karazin.shop.service.CartProductService;
import edu.karazin.shop.service.CartStore;
import edu.karazin.shop.service.CartStoreService;
import edu.karazin.shop.service.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {

	//XXX при входе в корзину, каждый раз пересчитывать
	
	private final ProductService productService;
	private final CartStore cartStore;
	private final CartStoreService cartStoreService;
	private final CartProductService cartProductService;

	//XXX инжектить через коснтруктор всё
	@Autowired 
	public CartController(ProductService productService, CartStore cartStore, CartStoreService cartStoreService, CartProductService cartProductService) {
		this.productService = productService;
		this.cartStore = cartStore;
		this.cartStoreService = cartStoreService;
		this.cartProductService = cartProductService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("products", cartStore.getProducts());
		return "cart-list";
	}
	//FIXME fix product adding to cart
	@RequestMapping(method = RequestMethod.GET, params = "add")
	public String addProduct(@RequestParam("prodId") long prodId, @RequestParam("amount") long productsAmount, Model model) {
		Product currentProduct = productService.getProduct(prodId);
		//long purchasePrice = currentProduct.getCost();
		long cartId = cartStoreService.getCartIdForCurrentUser();
		//CartProduct cartProduct = new CartProduct(cartId, currentProduct.getId());
		cartProductService.addCartProduct(cartId, currentProduct.getId(), productsAmount);
		return list(model);
	}
	//FIXME fix removing from cart
	@RequestMapping(method = RequestMethod.GET, params = "delete")
	public String removeProduct(@RequestParam("prodId") Long prodId, Model model) {
		//cartStore.removeProduct(productService.getProduct(prodId));
		return list(model);
	}
}
