package org.wellaware.test.auto.framework.pages;

import org.openqa.selenium.WebDriver;
import org.wellaware.test.auto.framework.util.WebDriverWrapper;
import org.wellaware.test.auto.framework.util.WebElementQueryHelper;

public class WikipediaHomePage {

	WebDriver driver;
	WebElementQueryHelper sizzle = null;

	public WikipediaHomePage(WebDriver driver) {
		this.driver = driver;
		sizzle = new WebElementQueryHelper(driver);
	}

	public ContinuousDeliveryPage searchWikipedia(String searchString) {

		searchString = "continuous delivery";

		sizzle.findElementByExtendedCss("#searchInput").sendKeys(searchString);
		sizzle.findElementByExtendedCss(".formBtn:nth(0)").click();

		return new ContinuousDeliveryPage(driver);
	}

}
