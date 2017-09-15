package lego.Utile;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5HashPassword {
	public static String getpassword(String username,String password){
		Md5Hash hash=new Md5Hash(password, username, 3);
		return hash.toString();
		
	}

}
