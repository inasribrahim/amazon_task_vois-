package com.amazon.vois.tests;

import com.amazon.vois.utils.generate_data.GenerateData;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class AmazonTest extends BaseTest{
    GenerateData generateData = new GenerateData();
    static int cardShoppingActualNumber = 0 ;

    /*VOIS Scenario 1 */

    @Test
    public void verifyThatUserSearchItemAndAbleToAddedToCartCorrectly() throws TesseractException, IOException, InterruptedException {
        String inputSearch = "car accessories";
        int firstSearchResult = 1;
        browser.amazon.captchaScreen.solveCaptcha();
         browser.amazon.home.getSearch().clickOnSearchField()
                .enterTextInSearch(inputSearch)
                .clickOnProductLinkInSearchResult(firstSearchResult);


        String firstProductTitle  = browser.amazon.productsDetails.getProductTitle(firstSearchResult);
        double firstPrice = browser.amazon.productsDetails.getPrice(firstSearchResult);


        browser.amazon.productsDetails.clickOnProductLinkResult(firstSearchResult)
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

    @Test
    public void verifyThatUserCannotLoginWithValidButNotRegisteredEmail(){
        String actualEmailNotFoundErrorMessage = "We cannot find an account with that email address";
        browser.amazon.home.clickOnSignInButton();
        assertEquals(browser.amazon.home.getSignIn()
                .enterEmailAddress(generateData.generateEmail())
                .clickOnContinueButton()
                .emailNotFoundErrorMessage(),actualEmailNotFoundErrorMessage);
    }

    @Test
    public void VerifyThatYouCannotSeeYourOrdersAndYourAddressesIfYouAreNotSigned() throws  InterruptedException {
        String refOrderNotSignedLink = "https://www.amazon.com/ap/signin";
        assertEquals(refOrderNotSignedLink,browser.amazon.home.mouseHoverOnAccountList().clickOnOrders().getCurrentUrl().split("\\?")[0]);

        browser.amazon.home.back();
        assertEquals(false,browser.amazon.home.mouseHoverOnAccountList().yourAddressIsExistedOrNot());

        assertEquals("Your Lists",browser.amazon.home.mouseHoverOnAccountList().getYourListText());

    }

}
