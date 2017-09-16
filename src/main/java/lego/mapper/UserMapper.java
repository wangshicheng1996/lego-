package lego.mapper;

import org.apache.ibatis.annotations.Param;

import lego.pojo.User;

public interface UserMapper {
	//根据用户名和密码进行查询用户
	User findUserByUP(@Param("username")String username, @Param("password")String password);
	//保存用户
	void saveUser(User user);

}
