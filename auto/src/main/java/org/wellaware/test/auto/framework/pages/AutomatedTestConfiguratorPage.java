package org.wellaware.test.auto.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wellaware.test.auto.TestData;
import org.wellaware.test.auto.framework.locators.Locators;
import org.wellaware.test.auto.framework.util.WebElementQueryHelper;

/**
 * Class that models Automated Test Configurator Page
 * 
 * @author Suraj J
 * 
 */

public class AutomatedTestConfiguratorPage {

	WebDriver driver = null;
	String url = "";
	WebElementQueryHelper sizzle = null;
	WebDriverWait wait;

	public AutomatedTestConfiguratorPage(WebDriver driver) {
		this.driver = driver;
		sizzle = new WebElementQueryHelper(driver);
	}

	private void selectSeleniumAsAPI() {
		sizzle.findElementByExtendedCss(
				Locators.AUTOMATED_TEST_CONFIGURATOR_PAGE.SELENIUM_API_BUTTON)
				.click();
	}

	private void selectAppiumAsAPI() {
		sizzle.findElementByExtendedCss(
				Locators.AUTOMATED_TEST_CONFIGURATOR_PAGE.APPIUM_API_BUTTON)
				.click();
	}

	public void selectAPI(TestData.APIType selectedAPIType) {

		if (selectedAPIType == TestData.APIType.SELENIUM)
			selectSeleniumAsAPI();
		else if (selectedAPIType == TestData.APIType.APPIUM)
			selectAppiumAsAPI();
	}

	private void selectDeviceAsPC() {
		sizzle.findElementByExtendedCss(
				Locators.AUTOMATED_TEST_CONFIGURATOR_PAGE.DEVICE_DROPDOWN)
				.click();
		sizzle.findElementByExtendedCss(".list-element :contains('PC')")
				.click();
	}

	public void selectDevice(TestData.DeviceType selectedDeviceType) {
		if (selectedDeviceType == TestData.DeviceType.PC) {
			selectDeviceAsPC();
		}
	}

	private void selectLinuxAsOS() {
		sizzle.findElementByExtendedCss(".select-logo.select").click();
		sizzle.findElementByExtendedCss(".list-element :contains('Linux')")
				.click();

	}

	public void selectOS(TestData.OSType selectedOSType) {
		if (selectedOSType == TestData.OSType.Linux) {
			selectLinuxAsOS();
		}
	}

	public void selectBrowser() {
		sizzle.findElementByExtendedCss(".select-a-browser").click();
		sizzle.findElementByExtendedCss(".firefox").click();
		sizzle.findElementByExtendedCss(
				"#firefox .list-element :contains('28')").click();
	}

	public void setRecordVideo(boolean checkRecordVideo) {
		sizzle.findElementByExtendedCss(".choice-options .col-md-7").click();

		wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.visibilityOf(sizzle
						.findElementByExtendedCss("[for='box1']"))).click();

	}

	public void setCodeLanguage() {
		sizzle.findElementByExtendedCss(
				".choice-code .ng-binding[href='#tab-ruby']").click();
	}

	public String getCode() {
		String code = sizzle.findElementByExtendedCss(".hljs.ruby").getText();
		return code;
	}

}
