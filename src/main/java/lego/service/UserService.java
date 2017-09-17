package lego.service;

import lego.pojo.User;

public interface UserService {
	
	
	
	//根据用户名和密码进行查询用户
	User findUserByUP(String userName, String password);
	//保存用户
	void saveUser(User user);
	//根据用户名查询用户
	User findUserByUserName(String username);

}
