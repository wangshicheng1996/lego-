package lego.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5HashPassword {
	//获取密文
	public static String getPassword(String username,String password){
		Md5Hash hash = new Md5Hash(password,username,3);
		return hash.toString();
	}
}
