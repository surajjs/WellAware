package org.wellaware.test.auto.framework.pages;

import org.openqa.selenium.WebDriver;
import org.wellaware.test.auto.framework.util.WebDriverWrapper;
import org.wellaware.test.auto.framework.util.WebElementQueryHelper;

public class ContinuousDeliveryPage {

	WebDriver driver;
	WebElementQueryHelper sizzle;

	public ContinuousDeliveryPage(WebDriver driver) {
		this.driver = driver;
		sizzle = new WebElementQueryHelper(driver);
	}

	public void openContinousDeliveryDiagram() {
		sizzle.findElementByExtendedCss(".image>img").click();
	}

	public void closeContinousDeliveryDiagram() {
		sizzle.findElementByExtendedCss(".mw-mmv-close").click();
	}

	public TestAutomationPage clickAutomatedTesting() {
		sizzle.findElementByExtendedCss(
				".mw-redirect[title='Automated testing']").click();
		return new TestAutomationPage(WebDriverWrapper.getWebDriver());
	}

}
