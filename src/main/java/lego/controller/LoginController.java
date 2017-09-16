package lego.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import lego.pojo.User;
import lego.service.UserService;
import lego.tool.MailUtil;

@Controller
public class LoginController {
	@Autowired
	private UserService userSerivce;
	//登录
	@RequestMapping("/login")
	public String login(String userName,String password,Model model,HttpSession session){
		 if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
			model.addAttribute("errorInfo", "用户名和密码不能为空");
			
			return"";
		 }  
		 	Integer i=0;
			User user=userSerivce.findUserByUP(userName,password);
			if(user==null){
				//证明用户名或密码为空
			   Integer e= (Integer)session.getAttribute("error");
			   if(e>5){
				   model.addAttribute("errorInfo","错误超过5次,请修改密码");
				   return "";			   
			   }
			   
				model.addAttribute("errorInfo","用户名或密码错误");
				i++;
				session.setAttribute("error", i);
						
				return "/sysadmin/login/login";
				
			}	
			
			//检查账户是否激活，remark为yes未激活，否为未激活
			//会发送激活邮件然后不允许登录，跳回首页
			/*代码实现*/
			
			
			session.setAttribute("sessionUser",user );		
			return "";
	
	}
		//退出
		@RequestMapping("/logout")
		public String logut(HttpSession session){
			session.removeAttribute("sessionUser");
			return "";
		}
		//注册
		@RequestMapping("/logoutj")
		public String registration(){
			
			return "";
		}
		//注册提交
		@RequestMapping("/logouth")
		public String savaregistration(User user){	

			userSerivce.saveUser(user);

			return "";
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
