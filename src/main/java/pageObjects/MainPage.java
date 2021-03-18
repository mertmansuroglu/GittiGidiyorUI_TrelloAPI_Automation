package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    public WebDriver driver;
    By headerLogin = By.xpath("//div[@data-cy='header-login-button']");
    By headerRegister = By.xpath("//div[@data-cy='header-register-button']");
    By headerSearchFind = By.cssSelector("div.search_blue_buton.mobile-search-button.robot-header-searchContainer-button.focused");
    By GirisYap = By.xpath("//div[text()='Giriş Yap']");
    By uyeol = By.xpath("//div[text()='Ücretsiz Üye Ol']");
    By hesabim = By.xpath("//div[@title='Hesabım']");
    By searchBox = By.xpath("//input[@data-cy='header-search-input']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement gethesabim() {
        return driver.findElement(hesabim);
    }

    public WebElement getheaderRegister() {
        return driver.findElement(headerRegister);
    }

    public WebElement getheaderLogin() {
        return driver.findElement(headerLogin);
    }

    public WebElement getGirisYap() {
        return driver.findElement(GirisYap);
    }

    public WebElement getUyeOl() {
        return driver.findElement(uyeol);
    }

    public WebElement getsearchBox() {
        return driver.findElement(searchBox);
    }

    public WebElement getheaderSearchFind() {
        return driver.findElement(headerSearchFind);
    }
}