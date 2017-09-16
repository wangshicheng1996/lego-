package lego.service;

import java.util.Date;


import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lego.mapper.UserMapper;
import lego.pojo.User;
import lego.tool.MD5Utils;
import lego.tool.MailUtil;
@Service
public class UserSerivceImpl  implements UserService{

	@Autowired
	private UserMapper userMapper;
		
	//根据用户名和密码进行查询用户
	public User findUserByUP(String userName, String password) {
		
		return userMapper.findUserByUP(userName,password);
	}

	//保存用户
	public void saveUser(User user) {
		//未进行邮箱激活
		user.setRemark("未激活");
		userMapper.saveUser(user);
		//获取发送邮件时间日时
		Date date = new Date();
		Integer h = date.getHours();
		String userId = MD5Utils.md5(user.getUserId());
		
		//提交之后进行邮箱验证
		try {
			MailUtil.send_mail(user.getEmail(),userId,h);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}


}
