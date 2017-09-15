package lego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lego.mapper.UserMapper;
import lego.pojo.User;
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
		userMapper.saveUser(user);
		
	}

}
