package lego.Controller;

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


import lego.Utile.MD5HashPassword;
import lego.pojo.User;
import lego.service.UserSerivce;

@Controller
public class LoginController {
     @Autowired
     private UserSerivce userService;
     
     @RequestMapping("")
     public String toLogin(String userName,String password,Model model,HttpSession session){
    	 
    	 //判断是否为空
    	 if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
    		 model.addAttribute("errorInfo", "用户名或密码不能为空");
    	 }
    	 //登录判断
    	 Integer i = 0;
    	 String md5Password=MD5HashPassword.getpassword(userName, password);
    	 User user=userService.findUserByUP(userName,md5Password);
 		 if(user==null){
 			 
 			Integer e= (Integer) session.getAttribute("error");
 			 if(e>5){
 				  model.addAttribute("errorInfo", "错误太多，请找回密码");
 				  return "";
 			  }
 			//证明用户名或密码为空
 			model.addAttribute("errorInfo","用户名或密码错误");
 			  i++;
 			  session.setAttribute("error", i);
 			return "";
 			
 		 }
 		
 		
 		
 		session.setAttribute("sessionUser",user );	
 	
 		
 		return "";
    	 

     }
     
    /* //登录
     @RequestMapping("")
     public String to(String userName,String password,Model model){
    	 //判断是否为空
    	 if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
    		 model.addAttribute("errorInfo", "用户名或密码不能为空");
    	 }
    	String MD5password=MD5HashPassword.getpassword(userName, password);
    	 //获取subject
    	 Subject subject=SecurityUtils.getSubject();
		//2定义登录的令牌/票 ,将用户名和密码包装成令牌
		 UsernamePasswordToken token=new UsernamePasswordToken(userName, password);
		  
		//3通过subjec进行登录操作
		 try {
				//表示登陆成功
				 subject.login(token);
				 //获取用户的真实信息
				User user=(User) subject.getPrincipal();
				 subject.getSession().setAttribute("sessionUser",user);
				 return "redirect:/home.action"; //如果登录成功，shiro将会放行所有请求
			} catch (AuthenticationException a) {
				//表示登录失败
				model.addAttribute("errorInfo","用户名或密码错误");
				a.printStackTrace();
				return "";
			}catch (Exception e) {
				//表示一些未知错误
				e.printStackTrace();
				model.addAttribute("errorInfo","发现未知错误，请联系管理员");
				return "";
			}
   	
     }*/
	@RequestMapping("/to")
	public String to(){
		
		return "index";
	}
	//退出
	@RequestMapping()
	public String logut(HttpSession session){
		session.removeAttribute("sessionUser");
		return"";
		
		
	}
	//跳转到首页
	@RequestMapping("")
	public String To(){
		return"";
	}
	//注册
	@RequestMapping("")
	public String registration(){
		return"";
	}
	//注册保存
	@RequestMapping("")
	public String saveRegistration(User user){
		userService.saveUser(user);
		return "";
	}
	
	
     
}
