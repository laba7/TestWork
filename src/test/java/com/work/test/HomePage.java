package com.work.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.work.test.util.Properties;


/**
 * Created by User on 30.04.2017.
 */
public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    public void profile(){
        driver.navigate().to(Properties.getBaseUrl());
        driver.findElement(By.id("topLoginLink")).click();
    }
}
