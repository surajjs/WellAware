package org.wellaware.test.auto.framework.pages;

import org.openqa.selenium.WebDriver;
import org.wellaware.test.auto.framework.util.WebElementQueryHelper;

/**
 * Class that models the Automated Test Configurator Page.
 * 
 * 
 */

public class AutomatedTestConfiguratorPage {

	WebDriver driver = null;
	String url = "";
	// SizzleSelector sizzle = null;
	WebElementQueryHelper sizzle = null;

	public AutomatedTestConfiguratorPage(WebDriver driver) {
		this.driver = driver;
		sizzle = new WebElementQueryHelper(driver);
	}

	public void selectSeleniumAPI() {
		sizzle.findElementByExtendedCss(".api-button:nth(0)").click();
	}

	public void selectDevice() {

	}

	public void selectOS() {

	}

	public void selectBrowser() {

	}

	public void clickShowAdvancedConfiguration() {
		sizzle.findElementByExtendedCss(".col-md-7").click();
	}

	public void checkUnCheckRecordVideo() {

	}

}
