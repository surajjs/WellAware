package org.wellaware.test.auto.framework.pages;

import org.openqa.selenium.WebDriver;
import org.wellaware.test.auto.framework.util.WebElementQueryHelper;

public class TestAutomationPage {

	WebDriver driver;
	WebElementQueryHelper sizzle;

	public TestAutomationPage(WebDriver driver) {
		this.driver = driver;
		sizzle = new WebElementQueryHelper(driver);
	}

	/*
	 * public boolean doesHeaderExist(TestData.Header headerName) { return
	 * sizzle.isElementPresent(); }
	 */
}
