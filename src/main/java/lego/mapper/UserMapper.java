package lego.mapper;



import lego.pojo.User;

public interface UserMapper {
	//根据用户名查询用户是否存在
	User findUserByUP(String userName, String md5Password);
	//用户注册保存
	void saveUser();

}
