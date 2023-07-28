package com.amazon.vois.screen;

import org.openqa.selenium.By;

public class LeftMenu extends BaseScreen{

    private final By headphonesCheckBox = By.xpath("//span[starts-with(text(),'Headphones & Earbuds')]");
    private final By groceryCheckBox = By.xpath("//span[starts-with(text(),'Grocery & Gourmet Food')]");
    private final By discount10OffOrMoreLink = By.xpath("//a[@data-csa-c-element-id='filter-discount-10-']");
    public LeftMenu scrollToHealthCheckBox(){
        scrollToElement(headphonesCheckBox);
        return this;
    }

    public LeftMenu clickOnHeadphonesCheckBox(){
        waitUtils.waitUntilElementUntilIsClickable(headphonesCheckBox).click();
        return this;
    }

    public LeftMenu clickOnGroceryCheckBox(){
        waitUtils.waitUntilElementUntilIsClickable(groceryCheckBox).click();
        return this;
    }

    public LeftMenu clickOnDiscount10OffOrMoreLink(){
        scrollToElement(discount10OffOrMoreLink);
        waitUtils.waitUntilElementUntilIsClickable(discount10OffOrMoreLink).click();
        return this;
    }
}
