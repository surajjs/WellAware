package org.wellaware.test.auto.framework.util;

import java.util.List;

//import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * This class helps you search for items, depending on what parameters we have
 * and how many elements we want to find
 */
public class WebElementQueryHelper {
	private static final String NO_JQUERY_FAILSAFE = "if(typeof jQuery == 'undefined') return null; ";

	private static final String sizzleUrl = "https://raw.github.com/jquery/sizzle/2.1.1/dist/sizzle.min.js";

	// private Logger logger = Logger.getLogger(WebElementQueryHelper.class);

	private WebDriver webDriver = null;

	private JavascriptExecutor driver;

	/**
	 * Constructor Instantiates a new web element query helper.
	 * 
	 * @param WebDriver
	 *            the web driver
	 */
	public WebElementQueryHelper(WebDriver webDriver) {
		driver = (JavascriptExecutor) webDriver;
		this.webDriver = webDriver;
	}

	/**
	 * Create the jQuery selection expression
	 * 
	 * @param selector
	 *            the css selector
	 * @return selector expression String for jQuery
	 */
	private String createJQuerySelectorExpression(String selector) {
		return NO_JQUERY_FAILSAFE + "return $.find(\"" + selector + "\")";
	}

	/**
	 * Create the Sizzle selection expression
	 * 
	 * @param selector
	 *            the css selector
	 * @return selector expression String for sizzle
	 */
	private String createSizzleSelectorExpression(String cssLocator) {
		return "return Sizzle(\"" + cssLocator + "\")";
	}

	/**
	 * Is the element currently present or not? Checks if is element present.
	 * 
	 * @param cssSelector
	 *            the css selector
	 * @return true, if is element present, false otherwise
	 */
	public boolean isElementPresent(String cssSelector) {
		String script = NO_JQUERY_FAILSAFE + "return jQuery.find('"
				+ cssSelector.trim() + ":visible')[0] != undefined";
		Object result = driver.executeScript(script);
		if (result == null) {
			return false;
		}
		if (result instanceof Boolean) {
			return (Boolean) result;
		}
		throw new IllegalStateException("Wrong result was returned by script "
				+ script + ": " + result);
	}

	/**
	 * Primary search method for selectors - allows all sizzle pseudo classes
	 * and core css.
	 * 
	 * @param cssLocator
	 * @return WebElement
	 */
	public WebElement findElementByExtendedCss(String cssLocator) {
		List<WebElement> elements = findElementsBySizzleCss(cssLocator);
		if (elements != null && elements.size() > 0) {
			return elements.get(0);
		}
		// if we get here, we cannot find the element via Sizzle.
		throw new NoSuchElementException("selector '" + cssLocator
				+ "' cannot be found in DOM");
	}

	/**
	 * Method creates the proper js expresion depending on if jQuery or Sizzle
	 * is loaded. Once expression is created, it js Executes that and returns a
	 * List of WebElements.
	 * 
	 * @param cssLocator
	 * @return List<WebElement>
	 */
	private List<WebElement> findElementsBySizzleCss(String cssLocator) {
		String javascriptExpression = "";

		if (isJQueryLoaded()) {
			javascriptExpression = createJQuerySelectorExpression(cssLocator);
			System.out.println(String.format(
					"jQuery Expression to locate object [%s].",
					javascriptExpression));
		} else if (isSizzleLoaded()) {
			javascriptExpression = createSizzleSelectorExpression(cssLocator);
			System.out.println(String.format(
					"Sizzle Expression to locate object [%s].",
					javascriptExpression));
		} else {
			System.out
					.println("jQuery or Sizzle is not loaded, attempting to inject Sizzle");
			injectSizzle();
			javascriptExpression = createSizzleSelectorExpression(cssLocator);
			System.out.println(String.format(
					"Sizzle Expression to locate object [%s].",
					javascriptExpression));
		}
		List<WebElement> elements = (List<WebElement>) ((JavascriptExecutor) webDriver)
				.executeScript(javascriptExpression);

		return elements;
	}

	/**
	 * Inject sizzle if needed.
	 */
	private void injectSizzle() {
		if (!isSizzleLoaded()) {
			injectSizzleScript();
		} else {
			return; // sizzle is ready
		}

		for (int i = 0; i < 40; i++) {
			if (isSizzleLoaded()) {
				return; // sizzle is loaded
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// FIX: nothing to print here
			}
			if (i % 10 == 0) {
				System.out
						.println(String.format(
								"Attempting to re-load SizzleCSS from {%s}",
								sizzleUrl));
				injectSizzle();
			}
		}

		if (!isSizzleLoaded()) {
			System.out
					.println("After so many tries, sizzle does not appear in DOM");
			throw new RuntimeException("Sizzle loading from (" + sizzleUrl
					+ ") has failed");
		}
	}

	/**
	 * Check if jQuery is loaded
	 * 
	 * @return true if jQuery is loaded, otherwise false
	 */
	public boolean isJQueryLoaded() {
		Boolean loaded = true;
		try {
			loaded = (Boolean) ((JavascriptExecutor) webDriver)
					.executeScript("return (window.jQuery != null);");

		} catch (WebDriverException e) {
			System.out
					.println(String
							.format("while trying to verify jQuery loading, WebDriver threw exception {%s} ",
									e.getMessage()));
			loaded = false;
		}
		return loaded;
	}

	/**
	 * Check if sizzle is loaded
	 * 
	 * @return true if sizzle is loaded, otherwise false
	 */
	public Boolean isSizzleLoaded() {
		Boolean loaded = true;
		try {
			loaded = (Boolean) ((JavascriptExecutor) webDriver)
					.executeScript("return (window.Sizzle != null);");

		} catch (WebDriverException e) {
			System.out
					.println(String
							.format("while trying to verify Sizzle loading, WebDriver threw exception {%s} ",
									e.getMessage()));
			loaded = false;
		}
		return loaded;
	}

	/**
	 * Inject sizzle 2.1.1	
	 */
	public void injectSizzleScript() {
		((JavascriptExecutor) webDriver)
				.executeScript(" var bodyTag = document.getElementsByTagName('body')[0];"
						+ "if (bodyTag) {"
						+ " var sizzl = document.createElement('script');"
						+ " sizzl.type = 'text/javascript';"
						+ " sizzl.src = '"
						+ sizzleUrl + "';" + " bodyTag.appendChild(sizzl);}");
	}
}
