package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


import core.utils.utils;

public class PO_login {

	WebDriver driver;

	public PO_login(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(how=How.ID,using="user_login")
	WebElement txt_username;

	@FindBy(how=How.ID,using="user_password")
	WebElement txt_password;

	@FindBy(how=How.NAME,using="submit")
	WebElement btn_signin;

	public void username(String arg1){
		try {
			txt_username.sendKeys(arg1);
			utils.WriteLogs("pass","username set with value as : " + arg1);
		} catch (Exception e) {
			e.printStackTrace();
			utils.WriteLogs("fail","Unable to set username with value as : u. "
					+ "Run time exception thrown. Exception: " + e.toString());	
		}
	}

	public void password(String arg2){
		try {
			txt_username.sendKeys(arg2);
			utils.WriteLogs("pass","Password set with value as : " + arg2);
		} catch (Exception e) {
			e.printStackTrace();
			utils.WriteLogs("fail","Unable to set Password with value as : u. "
					+ "Run time exception thrown. Exception: " + e.toString());	
		}
	}
	public void clickonsignin(){
		try {
			btn_signin.click();
			utils.WriteLogs("pass","clickonsignin set with value as : ");
		} catch (Exception e) {
			e.printStackTrace();
			utils.WriteLogs("fail","Unable to set clickonsignin: "
					+ "Run time exception thrown. Exception: " + e.toString());	
		}
	}

	public void KW_LoginApplication(String arg1,String arg2) {
		try {
			username(arg1);
			password(arg2);
			clickonsignin();
			utils.WriteLogs("fail","User name and password Set and Submit Button Clicked.");

			//CheckPoint
			String expected = "Zero - Account Summary";
			String actual = driver.getTitle();
			Assert.assertEquals(expected, actual);
			utils.WriteLogs("pass","Login Successfull");
		}catch(Exception e) {
			e.printStackTrace();
			utils.WriteLogs("fail","Unable to Login in to the Application "
					+ "Run time exception thrown. Exception: " + e.toString());	
		}

	}

}
