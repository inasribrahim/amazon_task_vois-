package com.amazon.vois.screen;

import org.openqa.selenium.By;


public class ProductsDetailsScreen extends BaseScreen{
    private final By results = By.xpath("//a[@class = 'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']");
    private final By productsTitle = By.xpath("//h2[@class=\"a-size-mini a-spacing-none a-color-base s-line-clamp-4\"]");
    private final By prices = By.xpath("//span[@class='a-price']");
    private final By addToCardButton = By.id("add-to-cart-button");
    private final By closeShoppingCart = By.id("attach-close_sideSheet-link");
    private final By goToCartButton = By.cssSelector("#sw-gtc > span:nth-child(1) > a:nth-child(1)");
    private final By cartShoppingRightSideClose = By.id("attach-close_sideSheet-link");
    public ProductsDetailsScreen clickOnAddToCardButton(){
        waitUtils.waitUntilElementUntilIsClickable(addToCardButton).click();
        return this;
    }
    public ProductsDetailsScreen clickOnProductLinkResult(int index){
        getElements(results).get(1 - index).click();
        return new ProductsDetailsScreen();
    }

    public ProductsDetailsScreen clickOnCloseCartShopping() throws InterruptedException {
        if(elementIsExisted(closeShoppingCart))
        {
            waitUtils.waitUntilElementUntilIsClickable(closeShoppingCart).click();
            waitUtils.sleep(5000);
        }
        return new ProductsDetailsScreen();
    }

    public void clickOnGoToCartButton() throws InterruptedException {
        closeCartShoppingRightSide();
        waitUtils.waitUntilElementUntilIsClickable(goToCartButton).click();
    }

    public void closeCartShoppingRightSide() throws InterruptedException {
        if(elementIsExisted(cartShoppingRightSideClose)){
            waitUtils.waitUntilElementUntilIsClickable(cartShoppingRightSideClose).click();
            waitUtils.sleep(3000);
        }
    }
    public String getProductTitle(int index){
        return getElements(productsTitle).get(1 - index).getText();
    }

    public Double getPrice(int index){
        String[] priceValueList = getElements(prices).get(1-index).getText().split("//$");
        String priceValue =   priceValueList[0].split("\\$")[1].trim().split("\\n")[0] +"."+ priceValueList[0].split("\\$")[1].trim().split("\\n")[1];
        return Double.parseDouble(priceValue);
    }
}
