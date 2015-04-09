package org.wellaware.test.auto.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wellaware.test.auto.framework.util.WebDriverWrapper;
import org.wellaware.test.auto.framework.util.WebElementQueryHelper;

public class ContinuousDeliveryPage {

	WebDriver driver;
	WebElementQueryHelper sizzle;
	WebDriverWait wait;

	public ContinuousDeliveryPage(WebDriver driver) {
		this.driver = driver;
		sizzle = new WebElementQueryHelper(driver);
	}

	public void openContinousDeliveryDiagram() {
		
		wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.visibilityOf(sizzle
						.findElementByExtendedCss("img[alt='Continuous Delivery process diagram.png']"))).click();
		try {
		    Thread.sleep(10000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
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
