package com.amazon.vois.tests;

import com.amazon.vois.browser.Browser;
import com.amazon.vois.driver.Driver;
import com.amazon.vois.utils.read_properties.ReadProperties;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {
    protected static Browser browser = new Browser();
    public static String getBrowserName() throws IOException {
        return ReadProperties.setAmazonConfig().getProperty("browserName");
    }

    @BeforeTest(alwaysRun = true)
    protected void setUp() throws IOException {
        Driver.initDriver(getBrowserName());
        Driver.setBrowserResolution();
    }

   @AfterTest(alwaysRun = true)
   protected void tearDown() {
       Driver.closeDriver();
   }
}
