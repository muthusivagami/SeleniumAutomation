package PropertiesFileUtility;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class PropertiesUtility {

	public String GetDatafromPropFile(String key) throws IOException{		
		FileInputStream fis=new FileInputStream("./ConfigData/NinzaCrmCommondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

}
