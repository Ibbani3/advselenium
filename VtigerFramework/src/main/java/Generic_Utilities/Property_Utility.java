package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility {
	public String getKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("D:\\Advance selinium\\VtigerFramework\\src\\test\\resources\\property_filedata.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}

}
