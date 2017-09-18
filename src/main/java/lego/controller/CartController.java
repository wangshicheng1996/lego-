package lego.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lego.pojo.CarAndCollection;
import lego.pojo.User;
import lego.service.CartService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	@RequestMapping("/shopcart")
	public String shopcart(HttpSession session,Model model){
		//User user = (User) session.getAttribute("user");
		List<CarAndCollection> cacList = cartService.findAllCart("1");
	    
		model.addAttribute("cacList", cacList);
		return "/home/shopcart";
	}
	@RequestMapping("/collection")
	public String collection(HttpSession session,Model model){
		List<CarAndCollection> cacList = cartService.findAllCollection("1");
		model.addAttribute("cacList", cacList);
		return "/person/collection";
	}
	@RequestMapping("/deleteCollection")
	public String deleteCollection(String productId,String userId){
		cartService.deleteCollection(productId,userId);
		return "redirect:/collection";
	}
	@RequestMapping("/addCart")
	public String addCart(String productId,String userId){
		cartService.addCart(productId,userId);
		return "redirect:/shopcart";
	}
	@RequestMapping("/deleteShop")
	public String deleteShop(String productId,String userId){
		cartService.deleteShop(productId,userId);
		return "redirect:/shopcart";
	}
	@RequestMapping("/addCollection")
	public String addCollection(String productId,String userId){
		cartService.addCollection(productId,userId);
		return "redirect:/collection";
	}
	@RequestMapping("/updateNum")
	public String updateNum(String productId,String userId,Integer pnum){
		cartService.updateNum(productId,userId,pnum);
		return "redirect:/shopcart";
	}
}
