package com.amazon.vois.screen;

import com.amazon.vois.driver.DriverManager;
import org.openqa.selenium.By;

public class TodaysDealsScreen extends BaseScreen{

    private final By nextButton = By.xpath("//a[text()='Next']");
    private final By allProductTextIsExistedFlag = By.xpath("//span[text()='All Departments']");
    private final By productSelected = By.xpath("//a[@class=\"a-link-normal s-no-hover s-underline-text s-underline-link-text s-link-style a-text-normal\"]");
    public TodaysDealsScreen scrollToNextButton(){
        scrollToElement(nextButton);
        return this;
    }

    public TodaysDealsScreen clickOnPageNumber(String number) throws InterruptedException {
        String xpath = "//a[text()='"+number+"']";
        waitUtils.sleep(2000);
        DriverManager.getWebDriver().findElement(By.xpath(constructXpath(xpath,number))).click();
        return this;
    }

    public TodaysDealsScreen clickOnProductName(String name) throws InterruptedException {
        String xpath = "//div[text()='"+name+"']";
        waitUtils.sleep(5000);
        DriverManager.getWebDriver().findElement(By.xpath(constructXpath(xpath,name))).click();
        return this;
    }

    public void clickOnProductWhichIsSelected(){
        if(elementIsExisted(allProductTextIsExistedFlag)){
            waitUtils.waitUntilElementUntilIsClickable(productSelected).click();
        }
    }


}

