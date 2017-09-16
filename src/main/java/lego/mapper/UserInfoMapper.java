package lego.mapper;

import lego.pojo.UserInfo;

public interface UserInfoMapper {

	public UserInfo findUserByUid(String userId);

}
