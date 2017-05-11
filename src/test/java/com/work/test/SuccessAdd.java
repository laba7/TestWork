package com.work.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 02.05.2017.
 */
public class SuccessAdd {

    private WebDriver driver;
    private WebDriverWait wait;
    private By profile = By.id("topLoginLink");
    private By ad = By.id("login-box-ads");

    public SuccessAdd(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void controlAd(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("topLoginLink")));
        WebElement profile = driver.findElement(this.profile);
        WebElement ad = driver.findElement(this.ad);
        profile.click();
//        Actions actions = new Actions(driver);
//        actions.moveToElement(profile)
//                .moveToElement(ad)
//                .click().build().perform();
    }
}
