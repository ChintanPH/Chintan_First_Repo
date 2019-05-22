package retailbanking.tc;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import core.utils.utils;
import retailbanking.po.PO_login;


public class SmokeTest {

	@Parameters({"url","browser"})
	@Test
	public void t_01_check_login(String url,String browserType) {
		try {

			WebDriver driver = utils.InvokeBrowser(browserType, url);


			PO_login po_Login = PageFactory.initElements(driver, PO_login.class);
			po_Login.KW_LoginApplication("username", "password");

			utils.WriteLogs("pass","Test Case completed");
		}catch(Exception e) {
			utils.WriteLogs("fail","Test failed");
			Assert.assertFalse(false);
		}

	}
}

