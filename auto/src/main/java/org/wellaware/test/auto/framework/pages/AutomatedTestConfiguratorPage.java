package org.wellaware.test.auto.framework.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wellaware.test.auto.framework.locators.Locators;
import org.wellaware.test.auto.framework.util.WebElementQueryHelper;
import org.wellaware.test.auto.framework.TestData;

;

/**
 * Class that models the Automated Test Configurator Page.
 * 
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

	private void selectSeleniumAPI() {
		sizzle.findElementByExtendedCss(
				Locators.AutomatedTestConfiguratorPage.SELENIUM_API_BUTTON)
				.click();
	}

	private void selectAppiumAPI() {
		sizzle.findElementByExtendedCss(
				Locators.AutomatedTestConfiguratorPage.APPIUM_API_BUTTON)
				.click();
	}

	public void selectAPI(TestData.APIType selectedAPIType) {

		if (selectedAPIType == TestData.APIType.SELENIUM)
			selectSeleniumAPI();
		else if (selectedAPIType == TestData.APIType.APPIUM)
			selectAppiumAPI();
	}

	public void selectDevice() {
		sizzle.findElementByExtendedCss(
				Locators.AutomatedTestConfiguratorPage.DEVICE_DROPDOWN).click();
		sizzle.findElementByExtendedCss(".list-element :contains('PC')")
				.click();
	}

	public void selectOS() {
		sizzle.findElementByExtendedCss(".select-logo.select").click();
		sizzle.findElementByExtendedCss(".list-element :contains('Linux')")
				.click();
		
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
		// sizzle.findElementByExtendedCss("input[ng-model='settingsVideo']").click();

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
