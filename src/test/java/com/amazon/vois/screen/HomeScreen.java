package com.amazon.vois.screen;

import com.amazon.vois.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomeScreen extends BaseScreen{

    private final SignIn signIn;
    private final Search search ;
    private final RobbinMenu robbinMenu;
    private final CartShoppingScreen cartShoppingScreen;
    private final By signInButton = By.id("nav-link-accountList");
    private final By yourOrders = By.id("nav_prefetch_yourorders");
    private final By yourAddress = By.xpath("//*[text()='Your Addresses']");
    private final By yourListsText = By.xpath("//*[text()='Your Lists']");

    private final LeftMenu leftMenu;
    public HomeScreen(){
        search = new Search();
        robbinMenu = new RobbinMenu();
        cartShoppingScreen = new CartShoppingScreen();
        leftMenu = new LeftMenu();
        signIn = new SignIn();
    }

    public Search getSearch() {
        return search;
    }

    public RobbinMenu getRobbinMenu() {
        return robbinMenu;
    }

    public CartShoppingScreen getCartShoppingScreen(){
        return cartShoppingScreen;
    }

    public LeftMenu getLeftMenu(){
        return leftMenu;
    }

    public SignIn getSignIn(){
        return signIn;
    }

    public String getYourListText(){
        return getElementText(yourListsText);
    }

    public SignIn clickOnSignInButton(){
        waitUtils.waitUntilElementUntilIsClickable(signInButton).click();
        return new SignIn();
    }
    public HomeScreen clickOnOrders(){
        waitUtils.waitUntilElementUntilIsVisible(yourOrders).click();
        return this;
    }

    public HomeScreen mouseHoverOnAccountList(){
        WebElement ele = DriverManager.getWebDriver().findElement(By.id("nav-link-accountList"));
        Actions action = new Actions(DriverManager.getWebDriver());
        action.moveToElement(ele).perform();
        return this;
    }
    public boolean yourAddressIsExistedOrNot(){
        return elementIsExisted(yourAddress);
    }

}
