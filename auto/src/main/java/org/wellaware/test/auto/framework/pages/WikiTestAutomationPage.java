package org.wellaware.test.auto.framework.pages;

import org.openqa.selenium.WebDriver;
import org.wellaware.test.auto.framework.locators.Locators;
import org.wellaware.test.auto.framework.util.WebElementQueryHelper;

public class WikiTestAutomationPage {

	WebDriver driver;
	WebElementQueryHelper sizzle;

	public WikiTestAutomationPage(WebDriver driver) {
		this.driver = driver;
		sizzle = new WebElementQueryHelper(driver);
	}

	public boolean isOverviewHeaderPresent() {
		return sizzle
				.isElementPresent(Locators.WIKI_TEST_AUTOMATION_PAGE.OVERVIEW_HEADER);
	}

	public boolean isCodeDrivenTestingHeaderPresent() {
		return sizzle
				.isElementPresent(Locators.WIKI_TEST_AUTOMATION_PAGE.CODE_DRIVEN_TESTING_HEADER);
	}
}
