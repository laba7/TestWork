package com.work.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 02.05.2017.
 */
public class AfterLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AfterLoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void buttonNewAd() {

        driver.findElement(By.cssSelector("#postNewAdLink")).click();
    }
}
