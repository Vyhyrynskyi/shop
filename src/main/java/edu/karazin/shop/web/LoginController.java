package edu.karazin.shop.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts(Model model){
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String searchProducts(Model model,
			@ModelAttribute("searchForm") LoginForm form) {
		return "forward:/";
	}
}
