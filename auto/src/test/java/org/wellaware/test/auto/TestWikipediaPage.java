package org.wellaware.test.auto;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.wellaware.test.auto.framework.pages.WikipediaHomePage;
import org.wellaware.test.auto.framework.util.ScreenShot;
import org.wellaware.test.auto.framework.util.WebDriverWrapper;

public class TestWikipediaPage {

	WebDriver driver = null;
	ScreenShot screenShot = null;
	String url = "";
	WikipediaHomePage wikiHomePage;

	@BeforeTest
	public void setup() {
		this.driver = WebDriverWrapper.getWebDriver();
		this.url = TestData.Wikipedia.URL;
		driver.get(url);
		wikiHomePage = new WikipediaHomePage(driver);

	}

	@Test(groups = "Wikipedia")
	public void assertValueMatchesSelection() {

	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}
