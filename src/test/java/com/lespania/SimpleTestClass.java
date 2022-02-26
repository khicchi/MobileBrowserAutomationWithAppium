package com.lespania;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SimpleTestClass {

    AppiumDriver<MobileElement> driver;

    @Test
    public void testMe() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("deviceName","Pixel3API30");
        desiredCapabilities.setCapability("deviceOrientation", "portrait");
        desiredCapabilities.setCapability("platformVersion","11.0");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("browserName", "Chrome");

        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        Thread.sleep(2000);

        driver.get("https://www.yahoo.com");
        WebElement news = driver.findElement(By.xpath("//a[contains(@class,'js-content-viewer rapidnofollow')]"));
        news.click();

        Thread.sleep(5000);

        driver.close();
    }

}
