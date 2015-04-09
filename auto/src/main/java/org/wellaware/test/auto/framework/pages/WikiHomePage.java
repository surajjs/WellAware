package org.wellaware.test.auto.framework.pages;

import org.openqa.selenium.WebDriver;
import org.wellaware.test.auto.framework.locators.Locators;
import org.wellaware.test.auto.framework.util.WebElementQueryHelper;

/**
 * Class that models the Home Page in Wiki.
 * 
 * 
 */

public class WikiHomePage {

	WebDriver driver;
	WebElementQueryHelper sizzle = null;

	public WikiHomePage(WebDriver driver) {
		this.driver = driver;
		sizzle = new WebElementQueryHelper(driver);
	}

	public WikiContinuousDeliveryPage searchWikipedia(String searchString) {

		searchString = "continuous delivery";

		sizzle.findElementByExtendedCss(
				Locators.WIKI_HOME_PAGE.SEARCH_INPUT_TEXT).sendKeys(
				searchString);
		sizzle.findElementByExtendedCss(
				Locators.WIKI_HOME_PAGE.SEARCH_SUBMIT_BUTTON).click();

		return new WikiContinuousDeliveryPage(driver);
	}

}
