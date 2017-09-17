package lego.pojo;

import java.util.Date;

import javax.persistence.Entity;
/**
 * 用户详细信息表
 * @author Administrator
 *
 */
@Entity(name="user_info_p")
public class UserInfo {
	private String userInfoId;//用户信息id
	private String name;//真实姓名
	private String gender;//性别
	private String cardNo;//身份证
	private Date birthday;//生日
	private String telephone;//电话
	private String email;//邮箱
	
	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}
