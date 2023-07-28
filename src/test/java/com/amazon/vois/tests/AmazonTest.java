package com.amazon.vois.tests;

import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class AmazonTest extends BaseTest{
    static int cardShoppingActualNumber = 0 ;

    /*VOIS Scenario 1 */

    @Test
    public void verifyScenario1() throws TesseractException, IOException, InterruptedException {
        String inputSearch = "car accessories";
        int firstSearchResult = 1;
        browser.amazon.captchaScreen.solveCaptcha();
         browser.amazon.home.getSearch().clickOnSearchField()
                .enterTextInSearch(inputSearch)
                .clickOnFirstLinkInSearchResult(firstSearchResult);


        String firstProductTitle  = browser.amazon.productsDetails.getFirstProductTitle(firstSearchResult);
        double firstPrice = browser.amazon.productsDetails.getFirstPrice(firstSearchResult);


        browser.amazon.productsDetails.clickOnFirstResult(firstSearchResult)
                    .clickOnAddToCardButton()
                    .clickOnCloseCartShopping()
                    .clickOnGoToCartButton();


        int cartNumber =  browser.amazon.home.getCartShoppingScreen().scrollToShoppingCart().getShoppingCartNumber();
        cardShoppingActualNumber++;
        assertEquals(cartNumber , cardShoppingActualNumber);
        double totalAmount = browser.amazon.goCartShopScreen.getTotalAmount();
        assertEquals(firstProductTitle,browser.amazon.home.getCartShoppingScreen()
                                                          .getProductTitleNameIsExistedInCartSopping(firstProductTitle));
        assertEquals(firstPrice,totalAmount);

    }

    /*VOIS Scenario 2 */

    @Test
    public void verifyScenario2() throws TesseractException, IOException, InterruptedException {
        String pageNumber = "2"; //Note :: there is no page number 4
        String productName = "Save on Tribit Kids Bluetooth Headphones with RGB Lights, Starlet02 Safe Sound Tech+ 85dBA Volume Limited, 56H Playtime & HiFi Stereo, Built-in Mic, Over Ear Kids Wireless Headphones for iPad/School/Tablet and more";
        browser.amazon.captchaScreen.solveCaptcha();
        browser.amazon.home.getRobbinMenu().clickOnTodayDetailsLink();
        browser.amazon.home.getLeftMenu()
                .scrollToHealthCheckBox()
                .clickOnHeadphonesCheckBox()
                .clickOnGroceryCheckBox()
                .clickOnDiscount10OffOrMoreLink();
        browser.amazon.home.getRobbinMenu().getTodaysDealsScreen()
                .scrollToNextButton()
                .clickOnPageNumber(pageNumber)
                .clickOnProductName(productName)
                .clickOnProductWhichIsSelected();

        browser.amazon.productsDetails.clickOnAddToCardButton().clickOnGoToCartButton();

    }

}
