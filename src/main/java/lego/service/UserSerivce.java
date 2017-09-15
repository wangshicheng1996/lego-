package lego.service;

import lego.pojo.User;

public interface UserSerivce {
	
	User findUserByUP(String userName, String md5Password);

	void saveUser(User user);


}
