package org.wellaware.test.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.wellaware.test.auto.framework.pages.ContinuousDeliveryPage;
import org.wellaware.test.auto.framework.pages.WikipediaHomePage;
import org.wellaware.test.auto.framework.util.ScreenShot;
import org.wellaware.test.auto.framework.util.WebDriverWrapper;

public class TestWikiContinuousDeliveryPage {

	WebDriver driver = null;
	ScreenShot screenShot = null;
	String url = "";
	WikipediaHomePage wikiHomePage;
	ContinuousDeliveryPage continuousDeliveryPage;
	WebDriverWait wait;


	
	public void setup() {
		this.driver = WebDriverWrapper.getWebDriver();
		//this.url = TestData.Wikipedia.URL;
		driver.get("http://www.wikipedia.org/");
		wikiHomePage = new WikipediaHomePage(driver);
		continuousDeliveryPage = wikiHomePage.searchWikipedia("searchString");
		continuousDeliveryPage.openContinousDeliveryDiagram();
		

	}

	@Test(groups = "Wikipedia")
	public void assertValueMatchesSelection() {
		setup();
		driver.quit();
	}

	@AfterMethod
	public void afterTest() {
		
	}

}
