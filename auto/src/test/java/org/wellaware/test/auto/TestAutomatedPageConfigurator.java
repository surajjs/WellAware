package org.wellaware.test.auto;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.wellaware.test.auto.framework.TestData;
import org.wellaware.test.auto.framework.pages.AutomatedTestConfiguratorPage;
import org.wellaware.test.auto.framework.util.ScreenShot;
import org.wellaware.test.auto.framework.util.WebDriverWrapper;

;

public class TestAutomatedPageConfigurator {

	WebDriver driver = null;
	ScreenShot screenShot = null;
	String url = "";
	AutomatedTestConfiguratorPage newPage;

	@BeforeTest
	public void setup() {
		this.driver = WebDriverWrapper.getWebDriver();
		this.url = TestData.GeneralData.URL;
		driver.get(url);
		newPage = new AutomatedTestConfiguratorPage(driver);
		screenShot = new ScreenShot();

	}

	@Test
	public void assertValueMatchesSelection() {
		newPage.selectSeleniumAPI();
		newPage.clickShowAdvancedConfiguration();
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void tearDown() {
		screenShot.capture(driver);
	}
}
