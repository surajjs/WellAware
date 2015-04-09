package org.wellaware.test.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.wellaware.test.auto.framework.pages.WikiContinuousDeliveryPage;
import org.wellaware.test.auto.framework.pages.WikiHomePage;
import org.wellaware.test.auto.framework.pages.WikiTestAutomationPage;
import org.wellaware.test.auto.framework.util.ScreenShot;
import org.wellaware.test.auto.framework.util.WebDriverWrapper;

public class TestWikiTestAutomationPage {

	WebDriver driver = null;
	ScreenShot screenShot = null;
	String url = "";
	WikiHomePage wikiHomePage;
	WikiContinuousDeliveryPage continuousDeliveryPage;
	WikiTestAutomationPage wikiTestAutomationPage;
	WebDriverWait wait;

	public void setup() {
		this.driver = WebDriverWrapper.getWebDriver();
		driver.get(TestData.Wikipedia.URL);
		wikiHomePage = new WikiHomePage(driver);
		continuousDeliveryPage = wikiHomePage
				.searchWikipedia(TestData.Wikipedia.SearchSring);
		continuousDeliveryPage.openContinousDeliveryDiagram();
		continuousDeliveryPage.closeContinousDeliveryDiagram();
		wikiTestAutomationPage = continuousDeliveryPage.clickAutomatedTesting();

	}

	@Test(groups = "Wiki")
	public void testCodeDrivenTestingHeaderExists() {
		setup();
		Assert.assertTrue(wikiTestAutomationPage
				.isCodeDrivenTestingHeaderPresent());
	}

	@Test(groups = "Wiki")
	public void testOverviewHeaderExists() {

		Assert.assertTrue(wikiTestAutomationPage.isOverviewHeaderPresent());

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
