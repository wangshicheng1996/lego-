package lego.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import lego.pojo.User;
import lego.service.UserService;
import lego.tool.MD5HashPassword;

@Controller
public class LoginController {
	@Autowired
	private UserService userSerivce;
	//登录
	@RequestMapping("/login")
	public String login(String userName,String password,Model model,HttpSession session,HttpServletResponse response){
		/**
		 * 1.判断用户输入的内容是否为空
		 * 2.通过用户名和密码进行查询操作 得到user对象
		 * 3.如果对象为null,证明用户名和密码不正确  编辑提示信息 页面跳转到登陆页面
		 * 4.如果user对象不为null 则证明用户名和密码正确， 跳转到系统首页
		 */
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			//证明用户名和密码为空
			model.addAttribute("errorInfo", "用户名和密码不能为空");
			//转向到登录页面
			return "/home/login";
		}
		//1.获取subject对象
		Subject subject = SecurityUtils.getSubject();
		//1-2.将用户输入的密码进行md5加密处理
		String md5Password = MD5HashPassword.getPassword(userName, password);
		//2.定义登录的令牌/票，将用户名和密码包装为令牌
		UsernamePasswordToken token = new UsernamePasswordToken(userName,md5Password);
		//3.通过subject进行登录操作
		try{
			subject.login(token);
			//获取用户的真实信息
			User user = (User)subject.getPrincipal();
			//获取session
			session.setAttribute("SessionUser", user);
			return "redirect:/home.action";//如果登录成功，shiro将会放心所有的请求
		} catch (AuthenticationException a) {
			//表示登录失败
			model.addAttribute("errorInfo", "用户名或密码错误");
			a.printStackTrace();
			return "/home/login";
		} catch (Exception e){
			//表示一些未知错误
			e.printStackTrace();
			model.addAttribute("errorInfo", "发现未知错误，联系管理员！！");
			return "/home/login";
		}
	}
	
	//退出
	@RequestMapping("/logout")
	public String logut(HttpSession session){
		session.removeAttribute("sessionUser");
		return "/home/login ";
	}
		
	//注册
	@RequestMapping("/regist")
	public String registration(){
			
		return "/home/register";
	}
	
	//注册提交
	@RequestMapping("/saveUser")
	public String savaregistration(User user){	

		userSerivce.saveUser(user);

		return "redirect:/login";
	}
	//验证
	@RequestMapping("验证")
	public String 验证(String userId,Integer h){	
		//根据userId查询
		
		//对比查询到的结果与接受到的数据
			
		//一致则更改user中的remark
			
		//不一致定时转发，提示验证失败然后到首页
		
		return "返回登录界面";
	}

}
