package lego.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropUtils {

	private static Properties prop;
	static{
		prop=new Properties();
		String path=PropUtils.class.getClassLoader().getResource("").getPath();
		try {
			prop.load(new FileInputStream(new File(path+"merchantInfo.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Properties getProp(){
		return prop;
	}
	public static String getProperty(String key){
		return prop.getProperty(key);
	}
}
