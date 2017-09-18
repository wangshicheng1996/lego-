package lego.service;

import java.util.List;

import lego.pojo.User;

public interface UserService {
	
	
	
	//根据用户名和密码进行查询用户
	User findUserByUP(String userName, String password);
	//保存用户
	void saveUser(User user);
	//根据用户名查询用户
	User findUserByUserName(String username);
	//查询用户20条记录
	List<User> findAllUser20(int m, int n);
	//根据id删除用户
	void deleteById(String userId);
	

}
