package com.everis.webmoto;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Ct_002 {
	private static PaginaDeLogin loginPage;

	@BeforeClass
	public static void beforeEach() {
		loginPage = new PaginaDeLogin();
	}

	@AfterClass
	public static void afterClass() throws InterruptedException {
		Thread.sleep(5000);
		loginPage.fechar();
	}

	@Test
	public void efetuarLogin() throws IOException, InterruptedException {
		loginPage.preencherFomularioDeLogin("dandasaev@hotmail.com", "123456");
		loginPage.entrar();

		Thread.sleep(5000);
		
		assertTrue(loginPage.isPaginaDeLogin());
		assertTrue(loginPage.contemItem("Daniel"));

		loginPage.takeScreenshot();
	}

}
