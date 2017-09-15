package lego.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lego.mapper.UserMapper;
import lego.pojo.User;

@Service
public class UserServiceImpl implements UserSerivce {

	@Autowired
	private UserMapper userMapper;
	
	//根据用户名查询用户是否存在
	public User findUserByUP(@Param("username")String userName, @Param("password")String md5Password) {
		
		return userMapper.findUserByUP(userName,md5Password);
	}

	
	//用户注册
	public void saveUser(User user) {
		userMapper.saveUser();
		
	}

}
