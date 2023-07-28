package com.amazon.vois.driver;

import com.amazon.vois.utils.read_properties.ReadProperties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;

import static com.amazon.vois.driver.DriverManager.*;


public final class Driver {
    private Driver(){}
    public static void initDriver(String browserName) throws IOException {

        if (isNull(getWebDriver())){
            if(browserName.equalsIgnoreCase("chrome")){
                setWebDriver(new ChromeDriver());
            }
            else if(browserName.equalsIgnoreCase("edge")){
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                setWebDriver(new EdgeDriver(edgeOptions));
            }
            else if(browserName.equalsIgnoreCase("firefox")){
                setWebDriver(new FirefoxDriver());
            }
            else if(browserName.equalsIgnoreCase("safari")){
                setWebDriver(new SafariDriver());
            }
            else if (browserName.equalsIgnoreCase("internetExplorer")){
                setWebDriver(new InternetExplorerDriver());
            }
            System.out.println(getUrl());
            getWebDriver().navigate().to(getUrl());
        }
    }
    public static void closeDriver(){
        if(isNotNull(getWebDriver())){
            getWebDriver().quit();
            unLoad();
        }
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNotNull(Object object) {
        return object != null;
    }

    public static String getUrl() throws IOException {
            return ReadProperties.setAmazonConfig().getProperty("amazonUrl");
    }

    public static void setBrowserResolution() throws IOException {
        String width = ReadProperties.setAmazonConfig().getProperty("browserWidth");
        String height = ReadProperties.setAmazonConfig().getProperty("browserHeight");
        Dimension dimension = new Dimension(convertStrToInt(width), convertStrToInt(height));
        DriverManager.getWebDriver().manage().window().setSize(dimension);
    }

    public static int convertStrToInt(String str){
        return Integer.parseInt(str);
    }
}
