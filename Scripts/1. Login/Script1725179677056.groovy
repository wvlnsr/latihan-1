import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//def username_field = findTestObject('Login Page/username_field')
//def password_field = findTestObject('Login Page/password_field')
//def login_btn = findTestObject('Login Page/login_btn')
def container = findTestObject('Catalog Page/container')
def error_msg = findTestObject('Login Page/error_msg')

//WebUI.openBrowser(GlobalVariable.baseURL)
//WebUI.maximizeWindow()
//WebUI.verifyTextPresent('Swag Labs', false)
//WebUI.setText(username_field, username)
//WebUI.setText(password_field, password)
//WebUI.click(login_btn)

CustomKeywords.'utilities.webKeyword.loginCuraWeb'(GlobalVariable.username, GlobalVariable.password)

//WebUI.openBrowser(GlobalVariable.baseURL)
//WebUI.maximizeWindow()
//WebUI.verifyTextPresent('Swag Labs', false)
//WebUI.setText(findTestObject('Login Page/username_field'), CustomKeywords.'utilities.webKeyword.randomStr'(10))
//WebUI.delay(5)
//WebUI.setText(findTestObject('Login Page/password_field'), password)
//WebUI.click(findTestObject('Login Page/login_btn'))

if (testType == 'P') {
    WebUI.verifyElementPresent(container, 0)
} else {
    WebUI.verifyElementText(error_msg, 'Login failed! Please ensure the username and password are valid')
}

CustomKeywords.'utilities.webKeyword.refreshBrowser'()

WebUI.closeBrowser()