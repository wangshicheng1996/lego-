package lego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lego.mapper.UserInfoMapper;
import lego.pojo.UserInfo;

@Service
public class UserInfoServicceImpl implements UserInfoServicce {
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public UserInfo findUserByUid(String userId) {
		
		return userInfoMapper.findUserByUid(userId);
	}

	//通过userId将个人详细信息查询出来
	public UserInfo findUserInfoById(String userId) {
		return	userInfoMapper.findUserInfoById(userId);
		
	}

	//修改个人信息
	public void updateUserInfomsg(UserInfo userinfo) {
		userInfoMapper.updateUserInfomsg(userinfo);
		
	}
}
