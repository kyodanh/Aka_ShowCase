package bookmark
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



class bookmarks {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Thực hiện mở hệ thống và nhập (.*) và (.*)")
	public void thực_hiện_mở_hệ_thống_và_nhập_testuser_và_akv_testuser(String username, String password) {
		// Write code here that turns the phrase above into concrete actions
		WebUI.openBrowser("")
		WebUI.navigateToUrl("https://dev.akaverse.net/theakaverseappapi/wp-login.php?loggedout=true&wp_lang=en_US")
		WebUI.maximizeWindow()

		WebUI.click(findTestObject("Object Repository/Login/username"))
		WebUI.sendKeys(findTestObject("Object Repository/Login/username"), username)
		WebUI.click(findTestObject("Object Repository/Login/password"))
		WebUI.sendKeys(findTestObject("Object Repository/Login/password"), password)
	}

	@When("Nhấn Login để thực hiện đăng nhập")
	public void nhấn_Login_để_thực_hiện_đăng_nhập() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.click(findTestObject("Object Repository/Login/btn_login"))
	}

	@And("Đăng nhập thành công và thực hiện mở màn hình trang chủ")
	public void đăng_nhập_thành_công_và_thực_hiện_mở_màn_hình_trang_chủ() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.click(findTestObject("Object Repository/Bookmarks/Bookmark thanh menu"))
		WebUI.click(findTestObject("Object Repository/Bookmarks/Bookmark list"))


	}
	@And("Thêm mới một (.*) bookmark")
	public void thêm_mới_một_Meo_bookmark(String Test) {
		WebUI.click(findTestObject("Object Repository/Bookmarks/Add new"))
		WebUI.click(findTestObject("Object Repository/Bookmarks/Textbox"))
		WebUI.sendKeys(findTestObject("Object Repository/Bookmarks/Textbox"), Test)
		WebUI.click(findTestObject("Object Repository/Bookmarks/Publish"))
	}
	@When("Tìm kiếm (.*) bookmark và xóa bookmark")
	public void tìm_kiếm_Meo_bookmark_và_xóa_Meo_bookmark(String Text) {
		WebUI.click(findTestObject("Object Repository/Bookmarks/Seachbox"))
		WebUI.sendKeys(findTestObject("Object Repository/Bookmarks/Seachbox"),Text)
		WebUI.click(findTestObject("Object Repository/Bookmarks/btn_Seach"))

		WebUI.click(findTestObject("Object Repository/Bookmarks/Checkboxxoa"))
		WebUI.click(findTestObject("Object Repository/Bookmarks/Luachon"))
		WebUI.click(findTestObject("Object Repository/Bookmarks/MovetoTrash"))
		WebUI.waitForPageLoad(8)
		WebUI.click(findTestObject("Object Repository/Bookmarks/Apply"))
	}
	@Then("Hoàn thành thêm mới và đóng hệ thống")
	public void hoàn_thành_thêm_mới_và_đóng_hệ_thống() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.waitForPageLoad(8)
		//		WebUI.closeBrowser()
	}
}