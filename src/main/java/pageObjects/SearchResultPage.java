package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

    public WebDriver driver;
    By SecondPage = By.xpath("//a[text()='2']");
    By SearchResultPanel = By.cssSelector("div.search-tab-area.clearfix");
    By CurrentPage = By.xpath("//a[@class='current']");
    By RelatedSearches = By.cssSelector("div.related-searches-wrapper");
    By SelectItem = By.xpath("//ul[@class='catalog-view clearfix products-container']//li//a[1]");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSecondPage() {
        return driver.findElement(SecondPage);
    }

    public WebElement getCurrentPage() {
        return driver.findElement(CurrentPage);
    }

    public WebElement getRelatedSearches() {
        return driver.findElement(RelatedSearches);
    }

    public WebElement getSearchResultPanel() {
        return driver.findElement(SearchResultPanel);
    }

    public List<WebElement> getCSelectItem() {
        return driver.findElements(SelectItem);
    }
}
