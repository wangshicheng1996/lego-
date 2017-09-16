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
		// TODO Auto-generated method stub
		return userInfoMapper.findUserByUid(userId);
	}

}
