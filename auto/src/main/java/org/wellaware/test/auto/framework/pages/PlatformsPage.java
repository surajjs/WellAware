package org.wellaware.test.auto.framework.pages;

import org.openqa.selenium.WebDriver;

/**
 * Class that models the Platforms Page.
 * 
 * 
 */

public class PlatformsPage {
	WebDriver driver;

	public AutomatedTestConfiguratorPage clickPlatformConfiguratorLink() {

		return new AutomatedTestConfiguratorPage(driver);

	}

}
