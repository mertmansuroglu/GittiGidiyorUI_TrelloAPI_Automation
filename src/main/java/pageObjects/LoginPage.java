package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
    By username = By.cssSelector("input#L-UserNameField");
    By password = By.cssSelector("input#L-PasswordField");
    By showHidePwd = By.cssSelector("div.showHidePwd");
    By LoginEnter = By.cssSelector("input#gg-login-enter");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getusername() {
        return driver.findElement(username);
    }

    public WebElement getpassword() {
        return driver.findElement(password);
    }

    public WebElement getLoginEnter() {
        return driver.findElement(LoginEnter);
    }
}

