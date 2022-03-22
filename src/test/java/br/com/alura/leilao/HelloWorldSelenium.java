package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {

    @Test
    public void hello() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver browser = (WebDriver) new ChromeDriver();
        browser.get("http://localhost:8080/leiloes");
        browser.quit();

    }

    @Test
    public void entraNoGoogleEPesquisaTecmundoNoCampo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver browser = (WebDriver) new ChromeDriver();
        browser.navigate().to("http://google.com.br");
        browser.quit();
    }
}
