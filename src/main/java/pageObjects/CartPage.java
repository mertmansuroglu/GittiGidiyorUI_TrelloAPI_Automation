package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    public WebDriver driver;


    By CartQuantityDropdown = By.cssSelector("div.gg-input.gg-input-select select.amount");
    By CartItemPrice = By.cssSelector("div.total-price");
    By CartItemDelete = By.xpath("//div[@class='gg-d-24 hidden-m update-buttons-container']   //a[@title='Sil']");
    By CartClearInfo = By.cssSelector("div.empty-cart-info.gg-w-24.gg-d-21.gg-t-24.gg-m-24");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCartQuantityDropdown() {
        return driver.findElement(CartQuantityDropdown);
    }

    public WebElement getCartItemPrice() {
        return driver.findElement(CartItemPrice);
    }

    public WebElement getCartItemDelete() {
        return driver.findElement(CartItemDelete);
    }

    public WebElement getCartClearInfo() {
        return driver.findElement(CartClearInfo);
    }
}