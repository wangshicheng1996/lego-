package lego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lego.pojo.Category;
import lego.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("Category")
	public String findAllCategory(Model model){
		List<Category> CategoryList=categoryService.findAllCategory();
		model.addAttribute("CategoryList", CategoryList);
		return "";
	}
	
    
}
