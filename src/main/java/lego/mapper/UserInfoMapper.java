package lego.mapper;

import lego.pojo.UserInfo;

public interface UserInfoMapper {

	public UserInfo findUserByUid(String userId);
	//修改个人信息
	void updateUserInfomsg(UserInfo userinfo);
	//通过userId将个人详细信息查询出来
	UserInfo findUserInfoById(String userId);


}
