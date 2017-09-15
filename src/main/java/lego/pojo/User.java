package lego.pojo;

import java.io.Serializable;

public class User implements Serializable{
  
  private String user_id; 
  private String username;
  private String password;
  private String permission_id;
  private String email;
  private String remark;
  
  private UserInfo userinfo;
 
   public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(String permission_id) {
		this.permission_id = permission_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	  
}
