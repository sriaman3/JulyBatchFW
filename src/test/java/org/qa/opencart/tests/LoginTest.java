package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.constants.AppConstants;
import org.qa.opencart.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	@DataProvider
	public Object[][] getLoginData() {
		
		return new Object[][] {
			{"FebBatch2024@opencart.com", "1234567"},
			{"FebBatch2024@opencart.com", "123456"}
		};
		
	}
	
	/**
	 * With Excel Data sheet
	 * @return 
	 * @return
	 */
	@DataProvider
	public Object[][] getLoginTestExcelData() {
		return ExcelUtil.getExcelData(AppConstants.LOGIN_DATA_SHEET_NAME);
		
	}
	
	
	@Test
	public void loginPageTitleTest() {
		
		String title = lp.getTitleofLoginPage();
		
		Assert.assertEquals("rtyu", AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(enabled=false)
	public void loginTest() {
		lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 2, dataProvider = "getLoginData", enabled =false)
	public void loginTest(String uN, String pwd) throws InterruptedException {
		lp.doLogin(uN, pwd);
	}
	
	
	@Test(priority = 2, dataProvider = "getLoginTestExcelData")
	public void getloginTestExcelData(String uN, String pwd) throws InterruptedException {
		 lp.doLogin(uN, pwd);
	}

}
