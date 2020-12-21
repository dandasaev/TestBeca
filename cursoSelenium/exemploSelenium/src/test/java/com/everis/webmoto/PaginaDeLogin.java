package com.everis.webmoto;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class PaginaDeLogin {

		
	private static final String URL_LOGIN = "https://login.webmotors.com.br/?&r=https://www.webmotors.com.br/carros/estoque?idcmpint=t1:c17:m07:webmotors:busca::verofertas&inst=header:webmotors::logar-ou-cadastrar";
	static WebDriver driver;

	
	public PaginaDeLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(URL_LOGIN);
;		}

	
	public void fechar() {	
	driver.quit();	
	}


	
	public void preencherFomularioDeLogin(String email, String senha) {
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("senha")).sendKeys(senha);
		
	}



	public void entrar() {
		driver.findElement(By.xpath("//*[@id=\"btnEntrar\"]")).click();
		
	}	
	
	public boolean isPaginaDeLogin() {
		return driver.getCurrentUrl().equals(URL_LOGIN);
		
	}


	public boolean contemItem(String string) {
		return driver.getPageSource().contains(string);
				
				
//				findElement(By.xpath("//*[@id=\"root\"]/header/nav/div/ul/li[5]")).getText().equals(string);
		
	}
	
	public void takeScreenshot() throws IOException {
		SimpleDateFormat formatoDeData = new SimpleDateFormat("yyyyMMdd-HHmmss-SSSS");
		String fileName = formatoDeData.format(new Date());
		String shotName = String.format("%s.png", fileName);
		File finalShotFile = new File("C:\\cursoSelenium\\exemploSelenium\\screenshots", shotName);
		File shotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shotFile, finalShotFile);
	}


	public void maximizarPagina() {
		driver.manage().window().maximize();
		
		
	}


	public void entrarComContaGoogle() {
		driver.findElement(By.xpath("//*[@id=\"btnEntrarGoogle\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("daniel.dasaev.silva@everis");
		
	}

	
	
	
}
