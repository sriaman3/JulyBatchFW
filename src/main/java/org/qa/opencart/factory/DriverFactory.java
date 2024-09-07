package org.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.qa.opencart.exception.FrameworkException;

public class DriverFactory {

	static WebDriver driver;
	Properties prop;

	public WebDriver init_driver(String browerName) {
		// String browerName = browerName.getProperty("browser");
		switch (browerName.toLowerCase().trim()) {
		case "edge":
			driver = new EdgeDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			throw new FrameworkException("Please pass the correct borwser name" + browerName);

		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}

	public Properties init_prop() {

		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public String getScreenshot(String methodName) {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis()
				+ ".png";

		File destination = new File(path);

		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

}
