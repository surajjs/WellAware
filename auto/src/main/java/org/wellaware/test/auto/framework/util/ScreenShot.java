package org.wellaware.test.auto.framework.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	WebDriver driver = null;

	public ScreenShot() {

	}

	public void capture(WebDriver driver) {

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		Path path = FileSystems.getDefault().getPath(
				System.getProperty("user.dir") + "\\Screenshots",
				"screenshot.png");

		try {

			File screenShotPNG = new File(
					Constants.LocalRunConfig.SCREENSHOT_FILENAME);

			if (screenShotPNG.exists())
				Files.delete(path);

			FileUtils.copyFile(scrFile, new File(
					Constants.LocalRunConfig.SCREENSHOT_FILENAME));
		} catch (IOException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
