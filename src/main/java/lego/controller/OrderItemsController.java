package lego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lego.pojo.OrderItems;
import lego.service.OrderItemsService;

@Controller
public class OrderItemsController {
	@Autowired
	private OrderItemsService orderItemsService;
	
	
	//查询所有订单信息
	@RequestMapping("/orderList")
	public String findAll(Model model,String userId){
		
		userId = "1";
		List<OrderItems> itemsList = orderItemsService.findAll(userId);
		model.addAttribute("itemsList", itemsList);
		return "/person/order";
	}
	
}
