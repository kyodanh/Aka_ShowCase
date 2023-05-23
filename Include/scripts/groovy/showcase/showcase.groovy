package showcase
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

import org.openqa.selenium.Keys as Keys

class showcase {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@When("User thực hiện mở trang showcase")
	public void user_thực_hiện_mở_trang_showcase() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.click(findTestObject("Object Repository/Menu/btn_showcase"))
	}

	@Then("Hệ thống hiển thị table danh sách của trang showcase")
	public void hệ_thống_hiển_thị_table_danh_sách_của_trang_showcase() {
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
	
	
	@When("User thực hiện bấm vào add new")
	public void user_thực_hiện_bấm_vào_add_new() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.click(findTestObject("Object Repository/ShowCase/btn_addnew"))
	}
	
	@When("User thực hiện nhập thông tin thêm mới gồm title showcase : test , nội dung showcase : test")
	public void user_thực_hiện_nhập_thông_tin_thêm_mới_gồm_title_showcase_test_nội_dung_showcase_test() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.click(findTestObject("Object Repository/ShowCase/txt_title"))
		WebUI.sendKeys(findTestObject("Object Repository/ShowCase/txt_title"),"test title")
		
		WebUI.click(findTestObject('Object Repository/demo_sd/Page_Add New New  The akaVerse App  WordPress/html_mce-content-body div.mce-resizehandle _b7d6de'))

WebUI.setText(findTestObject('Object Repository/demo_sd/Page_Add New New  The akaVerse App  WordPress/body_test noi dung'),
	'<p style="">test noi dung</p><div id="katalon" style="top: 0px;"><div id="katalon-rec_elementInfoDiv" style="display: none;"></div></div>')
	}
	
	@When("User thực hiện thêm mới ảnh feature image và logo")
	public void user_thực_hiện_thêm_mới_ảnh_feature_image_và_logo() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.scrollToElement(findTestObject('Object Repository/ShowCase/feature_image'), 3)
		WebUI.click(findTestObject("Object Repository/ShowCase/feature_image"))
		def a = WebUI.getAttribute(findTestObject("Object Repository/ShowCase/hinh/hinh_1"), "data-id")
		KeywordUtil.logInfo(a)
		WebUI.click(findTestObject("Object Repository/ShowCase/hinh/hinh_1")) //cần làm câu lệnh loop để lấy hết ID
		WebUI.click(findTestObject("Object Repository/ShowCase/hinh/btn_chonhinh")) //cần làm câu lệnh loop để lấy hết ID
	}
	
	@When("User thực hiện chọn category , position và tab cho ở màn hình showcase")
	public void user_thực_hiện_chọn_category_position_và_tab_cho_ở_màn_hình_showcase() {
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions
		WebUI.sendKeys(findTestObject("Object Repository/ShowCase/category/radio_button_360"),Keys.chord(Keys.END))
		def a = WebUI.getAttribute(findTestObject("Object Repository/ShowCase/category/radio_button_360"), "value")
		KeywordUtil.logInfo(a)
		WebUI.click(findTestObject("Object Repository/ShowCase/category/radio_button_360")) //cần làm câu lệnh loop để lấy hết ID
		/////////
		WebUI.sendKeys(findTestObject("Object Repository/ShowCase/positions/positions"),Keys.chord(Keys.END))
		def b = WebUI.getAttribute(findTestObject("Object Repository/ShowCase/positions/radio_newpage"), "value")
		KeywordUtil.logInfo(b)
		WebUI.click(findTestObject("Object Repository/ShowCase/positions/radio_newpage")) //cần làm câu lệnh loop để lấy hết ID
	}
	
	@When("User thực hiện nhập thông tin web")
	public void user_thực_hiện_nhập_thông_tin_web() {
		// Write code here that turns the phrase above into concrete actions
		
	}
	
	@When("user thực hiện chọn hình")
	public void user_thực_hiện_chọn_hình() {
		// Write code here that turns the phrase above into concrete actions
	
	}
	
	@When("User bấm vào publist showcase")
	public void user_bấm_vào_publist_showcase() {
		// Write code here that turns the phrase above into concrete actions
		
	}
	
	@Then("Hệ thống hiển thị thông báo publish showcase thành công")
	public void hệ_thống_hiển_thị_thông_báo_publish_showcase_thành_công() {
		// Write code here that turns the phrase above into concrete actions
		
	}
}