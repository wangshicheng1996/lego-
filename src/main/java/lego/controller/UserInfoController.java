package lego.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

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
public class UserInfoController extends BaseController {
	@Autowired
	private UserInfoServicce userInfoServicce;
	@Autowired
	private UserService userService;
	
	
	//查看用户信息
	@RequestMapping("/toview")
	public String toView(HttpSession session,String userId,Model model){
		userId="2";
		session.setAttribute("userId", userId);
		UserInfo userinfolist = userInfoServicce.findUserByUid(userId);
			
		model.addAttribute("userinfolist", userinfolist);
			
		return "/person/information";
	}
	//修改密码
	@RequestMapping("/person/savepassword")
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
	@RequestMapping("/person/baocunmima")
	public String savepassword(User user){
	//  userService.updatepasword(user);
		return "/home/login";
	}
	//个人信息修改
	@RequestMapping("/person/information") 
	public String changemsg(String userId,Model model,HttpSession session){	
		//通过userId将个人详细信息查询出来
		userId="2";
		UserInfo userinfolist=userInfoServicce.findUserInfoById(userId);	
		model.addAttribute("userinfolist",userinfolist);
		return "/person/information";
	}
	//个人信息修改提交
	@RequestMapping("/person/saveuserinfo")
	public String savemsg(UserInfo userInfo){
		
	
		userInfoServicce.updateUserInfomsg(userInfo);
		
		return "redirect:/person/information";
	}
	//我的订单
	@RequestMapping("/person/order")
	public String Myorder(String userId){
		//根据用户id查询我的订单
		
		return "/person/bill";
	}

	
	
	
	
	
	
	
	
}
