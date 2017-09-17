package lego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lego.pojo.User;
import lego.pojo.UserInfo;
import lego.service.UserInfoServicce;
import lego.service.UserService;
import lego.tool.MD5HashPassword;
import lego.tool.MD5Utils;

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoServicce userInfoServicce;
	@Autowired
	private UserService userService;
	
	
	//查看用户信息
	@RequestMapping("/toview")
	public String toView(String userId,Model model){
			
		UserInfo user = userInfoServicce.findUserByUid(userId);
			
		model.addAttribute("user", user);
			
		return "/person/information";
	}
	//修改密码
	@RequestMapping("/person/password")
	public String changepassword(Model model,String username,String password,User user){
		/**
		 * 先进行是否登录判断,没有登录则跳转到登录界面，
		 * 若登录则跳转到修改界面
		 */
		user=userService.findUserByUP(username, password);
		if(user==null){
			//跳转到登录界面
			return"/home/login";
		}
		String md5password=MD5HashPassword.getPassword(username, password);
		user.setPassword(md5password);
		model.addAttribute("user",user);
		return "/person/password";
	}
	//修改密码提交
	@RequestMapping("/person/savepassword")
	public String savepassword(User user){
	  //userService.updatepasword(user);
		return "/home/login";
	}
	//个人信息修改
	@RequestMapping("/person/information") 
	public String changemsg(String userId,Model model){
		
		//通过userId将个人详细信息查询出来
		UserInfo userinfo=userInfoServicce.findUserInfoById(userId);
		model.addAttribute("userinfo",userinfo);
		return "/person/information";
	}
	//个人信息修改提交
	@RequestMapping("/person/saveuserinfo")
	public String savemsg(UserInfo userinfo){
		userInfoServicce.updateUserInfomsg(userinfo);
		
		return "/person/password";
	}
	//我的订单
	@RequestMapping("/person/order")
	public String Myorder(String userId){
		//根据用户id查询我的订单
		
		return "/person/bill";
	}

	
	
	
	
	
	
	
	
}
