package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import seleniumFramework.Base;
import seleniumFramework.Utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GittiGidiyorTest extends Base {
    public static String getItemPrice() throws IOException {
        itemPage ip = new itemPage(driver);
        String price = ip.getItemLowPrice().getText();
        return price;
    }

    @Given("I open the browser {string}")
    public void iOpenTheBrowser(String browserName) throws IOException {
        driverInitialize(browserName);
    }

    @When("I  visit GittiGidiyor web page")
    public void iVisitGittiGidiyorWebPage() {
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Then("I check if the page is correctly opened {string}")
    public void iCheckIfThePageIsCorrectlyOpened(String webuRL) throws Exception {
        Thread.sleep(3000);
        try {
            Assert.assertEquals(webuRL, driver.getCurrentUrl());

        } catch (Throwable pageNavigationError) {
            throw new Exception("navigated to wrong page");
        }
    }

    @Then("I check if the browser has been closed")
    public void iCheckIfTheBrowserHasBeenClosed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @When("I click login button")
    public void iClickLoginButton() {
        driver.findElement(By.cssSelector("[title=\"Giriş Yap\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cy=\"header-login-button\"]"))).click();
    }

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LoginPage lp = new LoginPage(driver);
        lp.getusername().click();
        lp.getusername().sendKeys(username);

    }

    @And("I enter password as {string}")
    public void iEnterPasswordAs(String pwd) {
        LoginPage lp = new LoginPage(driver);
        lp.getpassword().click();
        lp.getpassword().sendKeys(pwd);
    }

    @And("I click login enter button")
    public void iClickLoginEnterButton() {
        LoginPage lp = new LoginPage(driver);
        lp.getLoginEnter().click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Then("I should be able to see that I login to the system")
    public void iShouldBeAbleToSeeThatILoginToTheSystem() {
        MainPage MP = new MainPage(driver);
        try {
            MP.gethesabim().isDisplayed();
        } catch (java.util.NoSuchElementException e) {
            Assert.fail("Error you did not succesfully login to the systme");
        }
        Assert.assertTrue(MP.gethesabim().isDisplayed());

    }

    @Given("I delete the cookies")
    public void iDeleteTheCookies() {
        driver.manage().deleteAllCookies();
    }

    @When("I search {string} in the search box")
    public void iSearchInTheSearchBox(String item) throws InterruptedException {
        MainPage mp = new MainPage(driver);

        mp.getsearchBox().click();
        mp.getsearchBox().sendKeys(item);
        Thread.sleep(2000);
        mp.getsearchBox().sendKeys(Keys.ENTER);
    }

    @Then("I should see the search result")
    public void iShouldSeeTheSearchResult() {
        SearchResultPage sp = new SearchResultPage(driver);
        try {
            sp.getSearchResultPanel().isDisplayed();
        } catch (java.util.NoSuchElementException e) {
            Assert.fail("Error you did not succesfully login to the systme");
        }
        Assert.assertTrue(sp.getSearchResultPanel().isDisplayed());

    }

    @When("I go to the second search page")
    public void iGoToTheSecondSearchPage() throws InterruptedException {
        Utilities ut = new Utilities(driver);
        SearchResultPage sp = new SearchResultPage(driver);
        ut.scrollToElement(sp.getRelatedSearches());
        Thread.sleep(2000);
        sp.getSecondPage().click();
    }

    @Then("I should see that second page has been opened")
    public void iShouldSeeThatSecondPageHasBeenOpened() {
        SearchResultPage sp = new SearchResultPage(driver);
        Utilities ut = new Utilities(driver);
        ut.scrollToElement(sp.getRelatedSearches());
        Assert.assertTrue(sp.getCurrentPage().getText().equalsIgnoreCase("2"));
        System.out.println(sp.getCurrentPage().getText());
        sp.getCurrentPage().click();
    }

    @When("I select one of the computers")
    public void iSelectOneOfTheComputers() {
        MainPage mp = new MainPage(driver);
        SearchResultPage sp = new SearchResultPage(driver);
        Utilities ut = new Utilities(driver);
        sp.getCSelectItem().get(0).click();

    }

    @Then("I should be redirected to the the item page")
    public void iShouldBeRedirectedToTheTheItemPage() throws InterruptedException {
        itemPage ip = new itemPage(driver);
        Thread.sleep(3000);
        try {
            ip.getItemGeneral().isDisplayed();
        } catch (java.util.NoSuchElementException e) {
            Assert.fail("Error you did not succesfully login to the systme");
        }
        Assert.assertTrue(ip.getItemGeneral().isDisplayed());
    }

    @And("I should be able to get the txt file including the item info and the price")
    public void iShouldBeAbleToGetTheTxtFileIncludingTheItemInfoAndThePrice() throws IOException {
        File file1 = new File("item.txt");
        itemPage ip = new itemPage(driver);

        FileWriter fw = new FileWriter(file1);
        fw.write("You can see the item info:  " + ip.getItemInfo().getText() + "\r\n");

        fw.write("You can see the item price:  " + ip.getItemLowPrice().getText());
        fw.close();

    }

    @When("I add the item to the cart")
    public void iAddTheItemToTheCart() throws InterruptedException {
        itemPage ip = new itemPage(driver);
        Utilities ut = new Utilities(driver);
//        ut.checkIfElementIsVisible(ip.getItemCartSepeteEkle());
        ut.scrollToElement(ip.getItemCartSepeteEkle());
        ip.getItemCartSepeteEkle().click();
    }


    @Then("I check the price of the added item is same in the cart")
    public void iCheckThePriceOfTheAddedItemIsSameInTheCart() throws InterruptedException {
        Actions a = new Actions(driver);
        itemPage ip = new itemPage(driver);
        CartPage cp = new CartPage(driver);
        String price = ip.getItemLowPrice().getText();
        Utilities ut = new Utilities(driver);
        a.moveToElement(ip.getItemCartSEPET()).build().perform();
        ut.checkIfElementIsVisible(ip.getItemCartSepeteGit());
        ip.getItemCartSepeteGit().click();
//        System.out.println(price);
        Select sdropdown = new Select(cp.getCartQuantityDropdown());
        sdropdown.selectByValue("1");
        Thread.sleep(3000);
//        System.out.println(cp.getCartItemPrice().getText());
        Assert.assertEquals(price, cp.getCartItemPrice().getText());

    }


    @When("I increase the amount of the cart item to {string}")
    public void iIncreaseTheAmountOfTheCartItemTo(String amount) throws InterruptedException {
        Actions a = new Actions(driver);
        itemPage ip = new itemPage(driver);
        CartPage cp = new CartPage(driver);
        Select sdropdown = new Select(cp.getCartQuantityDropdown());
        sdropdown.selectByValue(amount);
        Thread.sleep(3000);
    }

    @And("The cart amount should be {string}")
    public void theCartAmountShouldBe(String amount) {
        Actions a = new Actions(driver);
        itemPage ip = new itemPage(driver);
        CartPage cp = new CartPage(driver);
        Select sdropdown = new Select(cp.getCartQuantityDropdown());
        System.out.println(sdropdown.getFirstSelectedOption().getText());
        Assert.assertEquals(amount, sdropdown.getFirstSelectedOption().getText());
        ;
    }

    @Then("I go the cart")
    public void iGoTheCart() throws InterruptedException {
        Actions a = new Actions(driver);
        itemPage ip = new itemPage(driver);
        CartPage cp = new CartPage(driver);
        String price = ip.getItemLowPrice().getText();
        Utilities ut = new Utilities(driver);
        a.moveToElement(ip.getItemCartSEPET()).build().perform();
        ut.checkIfElementIsVisible(ip.getItemCartSepeteGit());
        ip.getItemCartSepeteGit().click();
//        System.out.println(price);
        Select sdropdown = new Select(cp.getCartQuantityDropdown());
        sdropdown.selectByValue("1");
        Thread.sleep(3000);
    }

    @When("I click delete cart button")
    public void iClickDeleteCartButton() {
        CartPage cp = new CartPage(driver);
        Utilities ut = new Utilities(driver);
        ut.checkIfElementIsVisible(cp.getCartItemDelete());
        cp.getCartItemDelete().click();

    }

    @Then("The item should be deleted from the cart")
    public void theItemShouldBeDeletedFromTheCart() {
        CartPage cp = new CartPage(driver);
        Utilities ut = new Utilities(driver);
        ut.checkIfElementIsVisible(cp.getCartClearInfo());
        Assert.assertTrue(cp.getCartClearInfo().isDisplayed());
    }



}

