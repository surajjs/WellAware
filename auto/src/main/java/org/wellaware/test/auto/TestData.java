package org.wellaware.test.auto;

/**
 * Class represents the Test Data that would be used
 * 
 * @author Suraj J
 * 
 */

public class TestData {

	public final class GeneralData {
		public final static String URL = "https://docs.saucelabs.com/reference/platforms-configurator/?_ga=1.5883444.608313.1428365147#/ ";
	}

	public final class Wikipedia {
		public final static String URL = "http://www.wikipedia.org ";
	}

	public enum APIType {
		SELENIUM, APPIUM
	};

	public enum DeviceType {
		PC, Mac
	};

	public enum OSType {

		Linux, Windows7("Windows 7");

		private String OSName;

		OSType() {

		}

		OSType(String OSName) {
			this.OSName = OSName;
		}

	};

	public enum BrowserType {
		FirefoxBeta("Firefox:beta"), Firefox30("Firefox:30.0"), Firefox29(
				"Firefox:29.0"), Firefox28("Firefox:28.0"), ChromeBeta(
				"Chrome:beta");

		private String browserVersion;

		BrowserType() {

		}

		BrowserType(String browserVersion) {
			this.browserVersion = browserVersion;
		}
	};

	public enum Header {
		Overview("Overview"), CodeDrivenTesting("Code-driven testing");
		private String header;

		Header() {

		}

		Header(String header) {
			this.header = header;
		}
	}

}
