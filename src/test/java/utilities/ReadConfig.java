package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig() {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/properties/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}
	
	public String getBaseUrl() {
		String baseurl = prop.getProperty("baseurl");
		return baseurl;
	}
	
}
