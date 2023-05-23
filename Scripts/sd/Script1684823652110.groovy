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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://dev.akaverse.net/theakaverseappapi/wp-login.php?redirect_to=https%3A%2F%2Fdev.akaverse.net%2Ftheakaverseappapi%2Fwp-admin%2Fpost-new.php%3Fpost_type%3Dnew&reauth=1')

WebUI.setText(findTestObject('Object Repository/demo_sd/Page_Log In  Mobile Showcase App/input_Username or Email Address_log'), 
    'testuser')

WebUI.setEncryptedText(findTestObject('Object Repository/demo_sd/Page_Log In  Mobile Showcase App/input_Password_pwd'), 
    't3eOfEzGI1k0B7Ug4pdaiCIZZV60QiRy')

WebUI.click(findTestObject('Object Repository/demo_sd/Page_Log In  Mobile Showcase App/input_Remember Me_wp-submit'))

WebUI.setText(findTestObject('Object Repository/demo_sd/Page_Add New New  The akaVerse App  WordPress/input_Add title_post_title'), 
    'tét tiele ')

WebUI.click(findTestObject('Object Repository/demo_sd/Page_Add New New  The akaVerse App  WordPress/p'))

WebUI.setText(findTestObject('Object Repository/demo_sd/Page_Add New New  The akaVerse App  WordPress/body_test noi dunghtml1'), 
    '<p style="">test noi dung</p><div id="katalon" style="top: 0px;"><div id="katalon-rec_elementInfoDiv" style="display: block;">/html[1]</div></div>')

//WebUI.click(findTestObject('Object Repository/demo_sd/Page_Add New New  The akaVerse App  WordPress/html_mce-content-body div.mce-resizehandle _b7d6de'))
//
//WebUI.setText(findTestObject('Object Repository/demo_sd/Page_Add New New  The akaVerse App  WordPress/body_test noi dung'), 
//    '<p style="">test noi dung</p><div id="katalon" style="top: 0px;"><div id="katalon-rec_elementInfoDiv" style="display: none;"></div></div>')

