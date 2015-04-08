package org.wellaware.test.auto.framework.util.environment;

import org.wellaware.test.auto.TestData;
import org.wellaware.test.auto.framework.util.Constants;

public class EnvironmentUtil {

	private Browser browser;
	private String url;
	private static EnvironmentUtil instance = new EnvironmentUtil();

	public static EnvironmentUtil getInstance() {
		return instance;
	}

	public EnvironmentUtil() {
		setBrowser();
		setURL();
	}

	private void setBrowser() {
		if (System.getProperty("browser") != null) {
			browser = Browser.valueOf(System.getProperty("browser"));
		} else {
			browser = Browser.valueOf(Constants.LocalRunConfig.BROWSER);
		}
	}

	public Browser getBrowser() {
		return browser;
	}

	private void setURL() {
		url = TestData.GeneralData.URL;
	}

}
