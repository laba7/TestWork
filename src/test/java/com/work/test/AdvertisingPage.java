package com.work.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 02.05.2017.
 */
public class AdvertisingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AdvertisingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void addAdvertising(){
       wait.until(ExpectedConditions.presenceOfElementLocated(By.className("olx-button olx-button--secondary")));
        driver.findElement(By.className("olx-button olx-button--secondary")).click();
    }
}
