package lego.service;

import lego.pojo.UserInfo;

public interface UserInfoServicce {

	public UserInfo findUserByUid(String userId);
	//根据id进行查询个人详细信息
	UserInfo findUserInfoById(String userId);
	//修改个人信息
	void updateUserInfomsg(UserInfo userinfo);

}
