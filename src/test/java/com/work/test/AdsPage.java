package com.work.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 03.05.2017.
 */
public class AdsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AdsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void deleteAds(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("myaccountview")));
        driver.findElement(By.className("link reporthov")).click();
    }
}
