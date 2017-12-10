package edu.karazin.shop.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.karazin.shop.entity.Product;
import edu.karazin.shop.service.ProductService;

@Controller
@RequestMapping("remove")
public class ProductDeleteController {

	private static final Logger log = LoggerFactory.getLogger(ProductEditController.class);

	private final ProductService productService;

	public ProductDeleteController(@Autowired ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String newProduct(Model model) {
		log.info("Render form for new product");

		model.addAttribute("product", new Product(null, "", ""));
		return "product-edit";
	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public String removeProduct(Model model, @PathVariable("id") Long productId) {
		log.info("Remove product");

		Product p = productService.getProduct(productId);
		if (p == null) {
			throw new NotFoundException();
		}

		model.addAttribute("product", p);
		return "product-remove";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addProduct(Model model, Product product) {
		log.info("Add product");
		productService.addProduct(product);
		return "redirect:/products";
	}

	@RequestMapping(method = RequestMethod.POST, path = "{id}")
	public String deleteProduct(Model model, Product product) {
		log.info("Update product");
		productService.updateProduct(product);
		return "redirect:/products";
	}
	
	/*@RequestMapping(method = RequestMethod.POST)
	public String removeProduct(Model model, Product product) {
		log.info("Remove product");
		productService.removeProduct(product.getId());
		return "redirect:/products";
	}*/
}