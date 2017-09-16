package lego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import lego.pojo.UserInfo;
import lego.service.UserInfoServicce;

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoServicce userInfoServicce;
	
	
	//查看用户信息
	@RequestMapping("/toview")
	public String toView(String userId,Model model){
			
		UserInfo user = userInfoServicce.findUserByUid(userId);
			
		model.addAttribute("user", user);
			
		return "";
	}
	
	
	
	
	
	
	
	
	
	
}
