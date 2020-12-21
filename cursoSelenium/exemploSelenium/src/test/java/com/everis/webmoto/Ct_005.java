package com.everis.webmoto;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Keyboard;

public class Ct_005 {
	static WebDriver driver;

	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void validarFiltroTrocaTroco() {
		driver.manage().window().maximize();
		driver.get("https://www.webmotors.com.br/carros/estoque?idcmpint=t1:c17:m07:webmotors:busca::verofertas");
		WebElement buscaLoc = driver.findElement(By.id("locationAutoComplete"));
		buscaLoc.sendKeys("são Paulo");
		buscaLoc.sendKeys(Keys.RETURN);
	}
	
	@After
	public void takeScreenshot() throws IOException{
		SimpleDateFormat formatoDeData = new SimpleDateFormat("yyyyMMdd-HHmmss-SSSS");
		String fileName = formatoDeData.format(new Date());
		String shotName = String.format("%s.png", fileName);
		File finalShotFile = new File("C:\\cursoSelenium\\exemploSelenium\\screenshots", shotName);
		File shotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shotFile, finalShotFile);
	}
	
	@AfterClass
	public static void quitDriver() throws InterruptedException {	
	Thread.sleep(5000);
	driver.quit();	
	}
}
