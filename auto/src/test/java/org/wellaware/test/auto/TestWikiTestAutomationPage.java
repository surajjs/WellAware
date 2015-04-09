package org.wellaware.test.auto;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.wellaware.test.auto.framework.pages.TestAutomationPage;
//import org.wellaware.test.auto.framework.pages.WikipediaHomePage;
import org.wellaware.test.auto.framework.util.WebDriverWrapper;

public class TestWikiTestAutomationPage {

	WebDriver driver;
	TestAutomationPage testWikiTestAutomationPage;
	
	public void setup() {
		this.driver = WebDriverWrapper.getWebDriver();
		//this.url = TestData.Wikipedia.URL;
		driver.get("http://www.wikipedia.org");
		//new WikipediaHomePage().searchWikipedia("Continuous Delivery");
		testWikiTestAutomationPage = new TestAutomationPage(driver);
		

	}
	@Test(groups = "Wikipedia")
	public void verifyHeaderOverview() {
		setup() ;
		driver.quit();
	}

	@Test(groups = "Wikipedia")
	public void verifyHeaderCodeDrivenTesting() {

	}

}
