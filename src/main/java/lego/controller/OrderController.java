package lego.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	/*//查询所有订单信息
	@RequestMapping("/orderItemsList")
	public String findAll(Model model,String userId){
		
		userId = "1";
		List<Order> orderList = orderService.findAll(userId);
		model.addAttribute("orderList", orderList);
		return "/person/order";
	}*/
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
	//新增订单
	@RequestMapping("/tocreate")
	public String toCreate(Model model) {
		// 跳转所有订单页面
		return "/home/shopcart";
	}

	// 保存订单信息
	/*@RequestMapping("/save")
	public String saveOrder(Order order) {

		orderService.saveOrder(order);
		// 跳转到订单页面
		return "redirect:/person/order";
	}*/
	
	//跳转到物流详情界面
	@RequestMapping("/logistic")
	public String toLogistic(HttpSession session){
		String num = "yuantong";
		String nu = "811423071327";
		
		session.setAttribute("num", num);
		session.setAttribute("nu", nu);
		
		return "/person/logistic";
	}
	
	//跳转到地图
	@RequestMapping("/map")
	public String toMap(HttpSession session){
		
		String receiveadd = "北京三里屯优衣库";
		String province = "北京";
		
		session.setAttribute("receiveadd", receiveadd);
		session.setAttribute("province", province);
		
		return "/person/map";
	}

}
