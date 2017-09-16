package lego.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lego.utils.VerifyCode;
@Controller
public class ValiImageController {

	
	public void toGetImg(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		
		VerifyCode vc = new VerifyCode();
		vc.drawImage(response.getOutputStream());
		String code = vc.getCode();
		System.out.println("验证码："+code);
		request.getSession().setAttribute("code", code);
		//model.addAttribute("code", code);
		
	}
	
}
