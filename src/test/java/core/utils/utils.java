package core.utils;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class utils {

	public static WebDriver InvokeBrowser(String browserType, String url) {
		try {
			WebDriver driver=null;
			if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\chintan\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver=new ChromeDriver();
			} else if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\chintan\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver=new ChromeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
			driver.get(url);
			utils.WriteLogs("pass","Browser Invoked with URL : " + url);
			return driver;
		} catch (Exception e) {
			utils.WriteLogs("fail","Unable to Invoke Browser. Type:" + browserType + " URL:" + url);
			return null;
		}
	}
	public static void WriteLogs(String logType,String msg) {
		Reporter.log(logType + "-" + msg + "<br>", true);
	}

}


