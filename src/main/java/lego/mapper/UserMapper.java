package lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import lego.pojo.User;

public interface UserMapper {
	//根据用户名和密码进行查询用户
	User findUserByUP(@Param("username")String username, @Param("password")String password);
	//保存用户
	void saveUser(User user);
	//根据用户名查询用户
	User findUserByUserName(String username);
	//显示25条用户
	List<User> findAllUser20(@Param("m")int m, @Param("n")int n);
	//根据id删除用户
	@Delete("delete from user_p where user_id=#{userId}")
	void deleteById(String userId);
	//激活
	@Update("update user_p set remark='激活' where user_id = #{userId}")
	void updateRemark(String userId);

}
