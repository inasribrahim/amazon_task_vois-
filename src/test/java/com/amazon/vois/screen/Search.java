package com.amazon.vois.screen;

import org.openqa.selenium.By;

public class Search extends BaseScreen{
    private final By searchField = By.id("twotabsearchtextbox");
    private final By searchResults = By.cssSelector(".left-pane-results-container > div:nth-child(1) > div:nth-child(1)");
    public Search clickOnSearchField(){
        waitUtils.waitUntilElementUntilIsClickable(searchField).click();
        return this;
    }
    public Search enterTextInSearch(String text){
        waitUtils.waitUntilElementIsPresence(searchField).sendKeys(text);
        return this;
    }

    public void clickOnProductLinkInSearchResult(int index) throws InterruptedException {
        waitUtils.sleep(5000);
        getElements(searchResults).get(1 - index).click();
    }

}
