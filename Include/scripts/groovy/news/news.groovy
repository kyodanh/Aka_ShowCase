package news
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.RenderingHints.Key

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
import groovy.inspect.swingui.BytecodeCollector

import org.openqa.selenium.Keys as Keys

class news {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User thực hiện truy cập web và đăng nhập với username : (.*) và password : (.*)")
	public void user_thực_hiện_truy_cập_web_và_đăng_nhập_với_username_testuser_và_password_akv(String username,String password) {
		// Write code here that turns the phrase above into concrete actions
		WebUI.openBrowser("")
		WebUI.navigateToUrl("https://dev.akaverse.net/theakaverseappapi/wp-login.php?loggedout=true&wp_lang=en_US")
		WebUI.maximizeWindow()
		WebUI.click(findTestObject("Object Repository/Login/username"))
		WebUI.sendKeys(findTestObject("Object Repository/Login/username"), username)
		WebUI.click(findTestObject("Object Repository/Login/password"))
		WebUI.sendKeys(findTestObject("Object Repository/Login/password"), password)
		WebUI.click(findTestObject("Object Repository/Login/btn_login"))
		def dashboard = WebUI.getText(findTestObject("Object Repository/Dashboard/txt_dashboard"))
		if (dashboard == "Dashboard") {
			KeywordUtil.logInfo("Hệ thống đã chuyển tới trang "+ dashboard)
		}else
			KeywordUtil.logInfo("Hệ thống không chuyển tới trang "+ dashboard)
	}

	@When("User thực hiện mở trang News")
	public void user_thực_hiện_mở_trang_News() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.click(findTestObject("Object Repository/Menu/btn_News"))
	}

	@Then("Hệ thống hiển thị table danh sách của trang New")
	public void hệ_thống_hiển_thị_table_danh_sách_của_trang_New() {
		// Write code here that turns the phrase above into concrete actions
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement Table = driver.findElement(By.xpath('//table/tbody'))
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		'To calculate no of rows In table'
		int rows_count = rows_table.size()

		'Loop will execute for all the rows of the table'
		Loop:
		for (int row = 0; row < rows_count; row++) {
			'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//		println((('Number of cells In Row ' + row) + ' are ') + columns_count)

			'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				'It will retrieve text from each cell'
				String celltext = Columns_row.get(column).getText()

				KeywordUtil.logInfo((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)
			}
		}
	}


	@When("User thực hiện bấm vào add news")
	public void user_thực_hiện_bấm_vào_add_news() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.click(findTestObject("Object Repository/News/btn_add_new"))
	}

	@When("User thực hiện nhập thông tin thêm mới gồm title : test , nội dung : test")
	public void user_thực_hiện_nhập_thông_tin_thêm_mới_gồm_title_test_nội_dung_test() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.click(findTestObject("Object Repository/News/txt_titlle"))
		WebUI.sendKeys(findTestObject("Object Repository/News/txt_titlle"),"test title")

		WebUI.click(findTestObject('Object Repository/demo_sd/Page_Add New New  The akaVerse App  WordPress/html_mce-content-body div.mce-resizehandle _b7d6de'))

		WebUI.setText(findTestObject('Object Repository/demo_sd/Page_Add New New  The akaVerse App  WordPress/body_test noi dung'),
				'<p style="">test noi dung</p><div id="katalon" style="top: 0px;"><div id="katalon-rec_elementInfoDiv" style="display: none;"></div></div>')


	}

	@When("User thực hiện thêm mới ảnh feature image")
	public void user_thực_hiện_thêm_mới_ảnh_feature_image() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.sendKeys(findTestObject("Object Repository/News/feature_image"),Keys.chord(Keys.END))
		WebUI.click(findTestObject("Object Repository/News/feature_image"))
		def a = WebUI.getAttribute(findTestObject("Object Repository/News/hinh/hinh_1"), "data-id")
		KeywordUtil.logInfo(a)
		WebUI.click(findTestObject("Object Repository/News/hinh/hinh_1")) //cần làm câu lệnh loop để lấy hết ID
		WebUI.click(findTestObject("Object Repository/News/hinh/btn_chonhinh")) //cần làm câu lệnh loop để lấy hết ID

	}


	@When("User thực hiện chọn category , position và tab")
	public void user_thực_hiện_chọn_category_position_và_tab() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.scrollToElement(findTestObject('Object Repository/News/category/radio_button_360'), 3)
//		WebUI.sendKeys(findTestObject("Object Repository/News/category/radio_button_360"),Keys.chord(Keys.END))
		def a = WebUI.getAttribute(findTestObject("Object Repository/News/category/radio_button_360"), "value")
		KeywordUtil.logInfo(a)
		WebUI.click(findTestObject("Object Repository/News/category/radio_button_360")) //cần làm câu lệnh loop để lấy hết ID
		/////////
		WebUI.scrollToElement(findTestObject('Object Repository/News/positions/positions'), 3)
//		WebUI.sendKeys(findTestObject("Object Repository/News/positions/positions"),Keys.chord(Keys.END))
		def b = WebUI.getAttribute(findTestObject("Object Repository/News/positions/radio_newpage"), "value")
		KeywordUtil.logInfo(b)
		WebUI.click(findTestObject("Object Repository/News/positions/radio_newpage")) //cần làm câu lệnh loop để lấy hết ID

	}

	@When("User thực hiện chọn showcase")
	public void user_thực_hiện_chọn_showcase() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.scrollToElement(findTestObject('Object Repository/News/showcase/label'), 3)
		WebUI.click(findTestObject("Object Repository/News/showcase/txt_showcase"))
		WebUI.sendKeys(findTestObject("Object Repository/News/showcase/txt_showcase"), "Car Configurator")
		WebUI.sendKeys(findTestObject("Object Repository/News/showcase/txt_showcase"),Keys.chord(Keys.ENTER))
	}

	@When("User bấm vào publist")
	public void user_bấm_vào_publist() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.click(findTestObject("Object Repository/News/button_publish"))
	}

	@Then("Hệ thống hiển thị thông báo thành công")
	public void hệ_thống_hiển_thị_thông_báo_thành_công() {
		// Write code here that turns the phrase above into concrete actions
		def text = WebUI.getText(findTestObject("Object Repository/ShowCase/thongbao_thanhcong"))
		KeywordUtil.logInfo(text)
		if(text=="Post published. View post") {
			KeywordUtil.logInfo("ShowCase được thêm mới thành công ("+text+")")
			WebUI.closeBrowser()
		}else {
			KeywordUtil.markFailedAndStop("Hệ thống thêm mới không thành công")
			WebUI.closeBrowser()
		}
	}
}