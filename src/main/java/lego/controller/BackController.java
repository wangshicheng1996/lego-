package lego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//后台管理
@Controller
public class BackController {
	
	//后台管理首页
	@RequestMapping("/back")
	public String manage(){
		return "/back/index";	
	}
	
	//商品管理
	@RequestMapping("/back/product")
	public String product(){
		
		return "/back/product";	
	}
	
	//用户管理
	@RequestMapping("/back/user")
	public String user(){
		return "/back/user";	
	}
	
	//权限管理
	@RequestMapping("/back/permissions")
	public String permissions(){
		return "/back/permissions";	
	}
	
	//销售管理
	@RequestMapping("/back/sale")
	public String sale(){
		return "/back/sale";	
	}
	
	//重定向到商城首页
	@RequestMapping("/back/index")
	public String index(){
		return "redirect:/index.jsp";	
	}

	

}
