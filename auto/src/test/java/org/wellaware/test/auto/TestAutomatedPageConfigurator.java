package org.wellaware.test.auto;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.wellaware.test.auto.framework.pages.AutomatedTestConfiguratorPage;
import org.wellaware.test.auto.framework.util.ScreenShot;
import org.wellaware.test.auto.framework.util.WebDriverWrapper;

public class TestAutomatedPageConfigurator {

	WebDriver driver = null;
	ScreenShot screenShot = null;
	String url = "";
	AutomatedTestConfiguratorPage automatedConfiguratorTestPage;

	public void setup() {
		this.driver = WebDriverWrapper.getWebDriver();
		this.url = TestData.GeneralData.URL;
		driver.get(url);
		automatedConfiguratorTestPage = new AutomatedTestConfiguratorPage(
				driver);
		screenShot = new ScreenShot();

	}

	@Test(groups = "SauceLabs")
	public void testCodeMatchesExpected() {
		setup();
		automatedConfiguratorTestPage.selectAPI(TestData.APIType.SELENIUM);
		automatedConfiguratorTestPage.selectDevice(TestData.DeviceType.PC);
		automatedConfiguratorTestPage.selectOS(TestData.OSType.Linux);
		automatedConfiguratorTestPage.selectBrowser();
		automatedConfiguratorTestPage.setRecordVideo(false);
		automatedConfiguratorTestPage.setCodeLanguage();

		Assert.assertEquals(automatedConfiguratorTestPage.getCode(),
				ExpectedResult.TestAutomatedPageConfigurator.expectedCode,
				"Actual Code Matches Expected");

	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		screenShot.capture(driver);
		driver.quit();
	}

}
