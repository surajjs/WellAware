package org.wellaware.test.auto.framework.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.wellaware.test.auto.framework.util.environment.Browser;
import org.wellaware.test.auto.framework.util.environment.EnvironmentUtil;

public class WebDriverWrapper {

	private static WebDriver driver = null;

	public static WebDriver getWebDriver() {

		final Browser browser = EnvironmentUtil.getInstance().getBrowser();
		return getWebDriver(browser);
	}

	public static WebDriver getWebDriver(Browser browser) {

		switch (browser) {
		case FIREFOX:
			getFirefoxBrowser();
			break;
		}
		return driver;
	}

	public static void getFirefoxBrowser() {
		System.setProperty("webdriver.assume.untrusted.issuer", "false");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
