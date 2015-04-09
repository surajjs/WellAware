package org.wellaware.test.auto.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wellaware.test.auto.framework.locators.Locators;
import org.wellaware.test.auto.framework.util.WebElementQueryHelper;

/**
 * Class that models the Continuous Delivery Page in Wiki.
 * 
 * 
 */
public class WikiContinuousDeliveryPage {

	WebDriver driver;
	WebElementQueryHelper sizzle;
	WebDriverWait wait;

	public WikiContinuousDeliveryPage(WebDriver driver) {
		this.driver = driver;
		sizzle = new WebElementQueryHelper(driver);
	}

	public void openContinousDeliveryDiagram() {

		wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.visibilityOf(sizzle
						.findElementByExtendedCss(Locators.WIKI_CONTINUOUS_DELIVERY_PAGE.CONTINUOUS_DELIVERY_IMAGE_LINK)))
				.click();

	}

	public void closeContinousDeliveryDiagram() {

		sizzle.findElementByExtendedCss(
				Locators.WIKI_CONTINUOUS_DELIVERY_PAGE.CONTINUOUS_DELIVERY_CLOSE_LINK)
				.click();
		;

	}

	public WikiTestAutomationPage clickAutomatedTesting() {
		sizzle.findElementByExtendedCss(
				Locators.WIKI_CONTINUOUS_DELIVERY_PAGE.AUTOMATED_TESTING_LINK)
				.click();
		return new WikiTestAutomationPage(driver);
	}

}
