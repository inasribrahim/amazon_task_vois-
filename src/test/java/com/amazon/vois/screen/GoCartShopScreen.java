package com.amazon.vois.screen;

import org.openqa.selenium.By;

public class GoCartShopScreen extends BaseScreen {

    private final By totalAmount = By.id("sc-subtotal-amount-buybox");

    public Double getTotalAmount(){
        return Double.parseDouble(getElementText(totalAmount).split("\\$")[1]);
    }
}