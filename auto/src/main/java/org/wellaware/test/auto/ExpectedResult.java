package org.wellaware.test.auto;

public class ExpectedResult {

	public final class TestAutomatedPageConfigurator {
		public final static String expectedCode = "caps = Selenium::WebDriver::Remote::Capabilities.firefox"
				+ "\n"
				+ "caps['platform'] = 'Linux'"
				+ "\n"
				+ "caps['version'] = '28.0'"
				+ "\n"
				+ "caps['record-video'] = false";

	}

}
