package seleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
    public WebDriver driver;
    By Frame = By.cssSelector("iframe.sp-fancybox-iframe.sp-fancybox-skin.sp-fancybox-iframe-959");

    public Utilities(WebDriver driver) {
        this.driver = driver;
    }


    public void WaitUntilEelement(By Byelement) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(Byelement));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);


    }

    public boolean checkIfElementIsVisible(WebElement element) {
        try {
            if (new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element)) != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


}