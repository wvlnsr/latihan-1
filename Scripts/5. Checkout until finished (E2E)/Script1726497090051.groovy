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

def sort = findTestObject('Catalog Page/sort')

def products = findTestObject('Catalog Page/product_list')

def productPrices = findTestObject('Catalog Page/product_price')

CustomKeywords.'utilities.webKeyword.loginCuraWeb'(GlobalVariable.username, GlobalVariable.password)

WebUI.selectOptionByValue(sort, 'lohi', false)

WebUI.verifyOptionSelectedByValue(sort, 'lohi', false, 0)

WebUI.verifyElementPresent(findTestObject('Catalog Page/1st_product'), 0)

WebUI.click(findTestObject('Catalog Page/1st_product'))

WebUI.verifyElementPresent(findTestObject('Detail Product Page/back_btn'), 0)

WebUI.click(findTestObject('Detail Product Page/add2cart_btn'))

WebUI.verifyElementPresent(findTestObject('Detail Product Page/remove_btn'), 0)

WebUI.click(findTestObject('Catalog Page/cart_icon'))

WebUI.click(findTestObject('Cart Page/back_btn'))

WebUI.click(findTestObject('Catalog Page/5th_product'))

WebUI.click(findTestObject('Detail Product Page/add2cart_btn'))

WebUI.click(findTestObject('Detail Product Page/back_btn'))

WebUI.click(findTestObject('Catalog Page/add2cart_btn'))

WebUI.click(findTestObject('Catalog Page/add2cart2_btn'))

WebUI.click(findTestObject('Catalog Page/cart_icon'))

WebUI.scrollToElement(findTestObject('Cart Page/checkout_btn'), 0)

WebUI.click(findTestObject('Cart Page/checkout_btn'))

WebUI.setText(findTestObject('Checkout Page/firstName_field'), CustomKeywords.'utilities.webKeyword.randomStr'(10))

WebUI.delay(2)

WebUI.setText(findTestObject('Checkout Page/lastName_field'), CustomKeywords.'utilities.webKeyword.randomStr'(10))

WebUI.delay(2)

WebUI.setText(findTestObject('Checkout Page/postal_field'), CustomKeywords.'utilities.webKeyword.randomInt'(5))

WebUI.delay(2)

WebUI.click(findTestObject('Checkout Page/continue_btn'))

WebUI.verifyTextPresent('Checkout: Overview', false)

WebUI.scrollToElement(findTestObject('Checkout Page/finish_btn'), 0)

WebUI.click(findTestObject('Checkout Page/finish_btn'))

WebUI.verifyTextPresent('Thank you for your order!', false)

WebUI.closeBrowser()

