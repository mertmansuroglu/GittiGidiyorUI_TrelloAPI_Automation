package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class itemPage {

    public WebDriver driver;
    By ItemGeneral = By.cssSelector("div#product-general-info");
    By ItemHighPrice = By.cssSelector("span#sp-price-highPrice");

    By ItemLowPrice = By.cssSelector("div#sp-price-lowPrice");
    By ItemCartPrice = By.cssSelector("button#add-to-basket");
    By ItemCartSepeteGit = By.cssSelector("a.gg-ui-btn-default.padding-none");
    By ItemCartSEPET = By.cssSelector("div.basket-icon-title.hidden-m.hidden-t");
    By ItemCartSepeteEkle = By.cssSelector("button#add-to-basket");

    By ItemInfo = By.cssSelector("h1#sp-title");

    public itemPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getItemGeneral() {
        return driver.findElement(ItemGeneral);
    }

    public WebElement getItemHighPrice() {
        return driver.findElement(ItemHighPrice);
    }

    public WebElement getItemLowPrice() {
        return driver.findElement(ItemLowPrice);
    }

    public WebElement getItemCartPrice() {
        return driver.findElement(ItemCartPrice);
    }

    public WebElement getItemCartSepeteGit() {
        return driver.findElement(ItemCartSepeteGit);
    }

    public WebElement getItemCartSepeteEkle() {
        return driver.findElement(ItemCartSepeteEkle);
    }

    public WebElement getItemCartSEPET() {
        return driver.findElement(ItemCartSEPET);
    }

    //    public WebElement getItemLowPrice() {
//        return driver.findElement(ItemLowPrice);
//    }
    public WebElement getItemInfo() {
        return driver.findElement(ItemInfo);
    }
}