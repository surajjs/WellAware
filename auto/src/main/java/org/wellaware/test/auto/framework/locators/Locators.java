package org.wellaware.test.auto.framework.locators;

/**
 * Central Repository for all locators
 * 
 * @author Suraj J
 * 
 */

public class Locators {

	public final class PlatformsPage {

	}

	public final class AUTOMATED_TEST_CONFIGURATOR_PAGE {

		public final static String SELENIUM_API_BUTTON = ".api-button:nth(0)";
		public final static String APPIUM_API_BUTTON = ".api-button:nth(1)";
		public final static String DEVICE_DROPDOWN = ".select-a-device";
		public final static String OS_DROPDOWN = "";
		public final static String BROWSER_DROPDOWN = "";
	}

	public final class WIKI_HOME_PAGE {
		public final static String SEARCH_INPUT_TEXT = "#searchInput";
		public final static String SEARCH_SUBMIT_BUTTON = ".formBtn:nth(0)";
	}

	public final class WIKI_CONTINUOUS_DELIVERY_PAGE {
		public final static String CONTINUOUS_DELIVERY_IMAGE_LINK = "img[alt='Continuous Delivery process diagram.png']";
		public final static String CONTINUOUS_DELIVERY_CLOSE_LINK = ".mw-mmv-close";
		public final static String AUTOMATED_TESTING_LINK = ".mw-redirect[title='Automated testing']";
	}

	public final class WIKI_TEST_AUTOMATION_PAGE {
		public final static String OVERVIEW_HEADER = "#Overview";
		public final static String CODE_DRIVEN_TESTING_HEADER = "#Code-driven_testing";

	}
}
