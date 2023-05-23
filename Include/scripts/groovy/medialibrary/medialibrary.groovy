package medialibrary
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



class medialibrary {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@When("Đăng nhập thành công và mở màn hình trang chủ")
	public void đăng_nhập_thành_công_và_mở_màn_hình_trang_chủ() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.click(findTestObject("Object Repository/MediaLibrary/Mediataskbar"))
		WebUI.click(findTestObject("Object Repository/MediaLibrary/Media them moi"))
	}

	@And("Thêm mới một Medialibrary")
	public void thêm_mới_một_Meo_Medialibrary() {
		// Write code here that turns the phrase above into concrete actions
		
		
		
//		WebUI.waitForPageLoad(5)
//		WebUI.uploadFile(findTestObject('Object Repository/MediaLibrary/Chọn file'), 'C:\\Users\\DanhNC14\\Desktop\\Apps\\Auto_Test\\Aka_ShowCase_Auto\\a.jpg')
//		WebUI.waitForPageLoad(5)
	}
}