package edu.karazin.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.karazin.shop.entity.CartProduct;
import edu.karazin.shop.entity.Product;
import edu.karazin.shop.service.CartStore;
import edu.karazin.shop.service.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {

	//XXX при входе в корзину, каждый раз пересчитывать
	
	private final ProductService productService;
	private final CartStore cartStore;

	//XXX инжектить через коснтруктор всё
	public CartController(@Autowired ProductService productService, @Autowired CartStore cartStore) {
		this.productService = productService;
		this.cartStore = cartStore;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("products", cartStore.getProducts());
		return "cart-list";
	}
	//FIXME fix product adding to cart
	@RequestMapping(method = RequestMethod.GET, params = "add")
	public String addProduct(@RequestParam("prodId") Long prodId, @RequestParam("amount") Long productsAmount, Model model) {
		//Product currentProduct = productService.getProduct(prodId);
		//long purchasePrice = currentProduct.getCost();
		//CartProduct cartProduct = new CartProduct(currentProduct, purchasePrice);
		//cartStore.addProduct(currentProduct);
		return list(model);
	}
	//FIXME fix removing from cart
	@RequestMapping(method = RequestMethod.GET, params = "delete")
	public String removeProduct(@RequestParam("prodId") Long prodId, Model model) {
		//cartStore.removeProduct(productService.getProduct(prodId));
		return list(model);
	}
}
