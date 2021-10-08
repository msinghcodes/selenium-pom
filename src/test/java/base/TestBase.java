package base;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class TestBase {
	
	static {
		String log4jpath=System.getProperty("user.dir")+"/src/test/resources/properties/log4j.xml";
        System.setProperty("logoutputpath", System.getProperty("user.dir")+"/src/test/resources/logs/");
        System.setProperty("log4j.configurationFile",log4jpath);
	}
	
	public static WebDriver driver;
	ReadConfig readConfig = new ReadConfig();
	private static Logger log = LogManager.getLogger(Log.class.getName());
	public String baseURL = readConfig.getBaseUrl();
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		log.info("Chrome driver is about to launch");
		driver = new FirefoxDriver();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
