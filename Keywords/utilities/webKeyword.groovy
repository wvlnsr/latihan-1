package utilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable
import org.openqa.selenium.WebDriver

public class webKeyword {
	@Keyword
	def loginCuraWeb(String username, String password) {
		WebUI.openBrowser(GlobalVariable.baseURL)
		WebUI.maximizeWindow()
		WebUI.verifyTextPresent('Swag Labs', false)
		WebUI.setText(findTestObject('Login Page/username_field'), username)
		WebUI.setText(findTestObject('Login Page/password_field'), password)
		WebUI.click(findTestObject('Login Page/login_btn'))
	}
	
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh Successfully")
	}

	@Keyword
	def randomStr(Integer length) {
		org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(length)
	}
		
	@Keyword
	def randomInt(Integer length) {
		org.apache.commons.lang3.RandomStringUtils.randomNumeric(length)
	}
	
	@Keyword
	def randomString = { Integer length ->
		String chars = "abcdefghijklmnopqrstuvwxyz"
		Random rand = new Random ();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<length; i++) {
			sb.append(chars.charAt(rand.nextInt(chars.length())));
		}
		return sb.toString();
	}
}
