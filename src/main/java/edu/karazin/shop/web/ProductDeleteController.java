package edu.karazin.shop.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping(method = RequestMethod.POST)
	public String removeProduct(Model model, @ModelAttribute Product product) {
		log.info("Remove product" + product.getId());
		productService.removeProduct(product.getId());
		return "redirect:/products";
	}
}
