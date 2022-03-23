package br.com.alura.leilao.login;

import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    public static final String URL_LOGIN = "http://localhost:8080/login";

    private WebDriver browser;


    public LoginPage() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        browser = (WebDriver) new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        this.browser.quit();
    }

    public void preencheFormularioDeLogin(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public LeiloesPage efetuaLogin() {
        browser.findElement(By.id("button-login")).click();
        return new LeiloesPage(browser);
    }

    public Boolean isPaginaDeLogin() {
      return browser.getCurrentUrl().contains(URL_LOGIN);
    }

    public String getNomeUsuarioLogado() {
       try {
           return browser.findElement(By.id("usuario-logado")).getText();
       } catch (NoSuchElementException e) {
            return null;
       }
    }

    public void navegaParaPaginaDeLances() {
        browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }
}
