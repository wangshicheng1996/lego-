package lego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lego.pojo.Product;
import lego.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("Product")
	public String findAllProduct(Model model){
		List<Product> productList=productService.findAllProduct();
		model.addAttribute("productList", productList);
		return "";
		
	}

}
