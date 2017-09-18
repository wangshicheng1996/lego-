package lego.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lego.mapper.UserMapper;
import lego.pojo.User;
import lego.tool.MD5HashPassword;
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
		user.setUserId(UUID.randomUUID().toString());
		user.setUsername("admin");
		user.setRemark("未激活");
		String md5Password = MD5HashPassword.getPassword(user.getUsername(),user.getPassword());
		user.setPassword(md5Password);
		userMapper.saveUser(user);
		
		//未进行邮箱激活
//		user.setRemark("未激活");
//		userMapper.saveUser(user);
//		//获取发送邮件时间日时
//		Date date = new Date();
//		Integer h = date.getHours();
//		String userId = MD5Utils.md5(user.getUserId());
//		
//		//提交之后进行邮箱验证
//		try {
//			MailUtil.send_mail(user.getUserInfo().getEmail(),userId,h);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
		
	}

	//根据用户名查询用户
	public User findUserByUserName(String username) {
		return userMapper.findUserByUserName(username);
	}

	//查询用户20条
	@Override
	public List<User> findAllUser20(int m, int n) {
		return userMapper.findAllUser20(m,n);
	}

	@Override
	public void deleteById(String userId) {
		userMapper.deleteById(userId);
	}

	@Override
	public void updateRemark(String userId) {
		userMapper.updateRemark(userId);
	}


}
