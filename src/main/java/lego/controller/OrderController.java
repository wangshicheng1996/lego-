package lego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lego.pojo.Order;
import lego.service.OrderService;


@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	//查询所有订单信息
	@RequestMapping("/orderList")
	public String findAll(Model model){
		List<Order> orderList = orderService.findAll();
		model.addAttribute("orderList", orderList);
		return "/person/order";
	}
	//删除订单
	@RequestMapping("/delete")
	public String toDelete(@RequestParam(value="orderId",required=true)String[] orderIds){
		
		orderService.deleteOrder(orderIds);
		
		//重定向订单页面
		return "redirect:/person/order";
	}

	//修改订单支付状态  1支付
	@RequestMapping("/start")
	public String toStart(@RequestParam(value="orderId",required=true)String[] orderIds){
		int paystate = 1;  //1已支付
		
		orderService.updateState(orderIds,paystate);
		
	
		return "redirect:/person/order";
	}
	//修改订单支付状态  0未支付
	@RequestMapping("/stop")
	public String toStop(@RequestParam(value="orderId",required=true)String[] orderIds){
		int paystate = 0;  //未支付
		orderService.updateState(orderIds,paystate);
		return "redirect:/person/order";
	}
	
	

}
