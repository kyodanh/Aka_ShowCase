package login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class login {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User thực hiện truy cập vào hệ thống")
	public void user_thực_hiện_truy_cập_vào_hệ_thống() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.openBrowser("")
		WebUI.navigateToUrl("https://dev.akaverse.net/theakaverseappapi/wp-login.php?loggedout=true&wp_lang=en_US")
		WebUI.maximizeWindow()
	}

	@When("User nhập thông tin (.*) và (.*)")
	public void user_nhập_thông_tin_testuser_và_akv_âs(String username , String password) {
		// Write code here that turns the phrase above into concrete actions
        WebUI.click(findTestObject("Object Repository/Login/username"))
		WebUI.sendKeys(findTestObject("Object Repository/Login/username"), username)
		WebUI.click(findTestObject("Object Repository/Login/password"))
		WebUI.sendKeys(findTestObject("Object Repository/Login/password"), password)
		
	}


	@Then("User thực hiện bấm login")
	public void user_thực_hiện_bấm_login() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.click(findTestObject("Object Repository/Login/btn_login"))
	}

	@Then("Hệ thống thông báo thành công và chuyển tới màn hình dashboard")
	public void hệ_thống_thông_báo_thành_công_và_chuyển_tới_màn_hình_dashboard() {
		// Write code here that turns the phrase above into concrete actions
		def dashboard = WebUI.getText(findTestObject("Object Repository/Dashboard/txt_dashboard"))
		
		if (dashboard == "Dashboard") {
		KeywordUtil.logInfo("Hệ thống đã chuyển tới trang "+ dashboard)
		}else 
		KeywordUtil.logInfo("Hệ thống không chuyển tới trang "+ dashboard)
		
	}
}