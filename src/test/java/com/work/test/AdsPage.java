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
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/div/div[2]/div[6]/div[2]/table/tbody/tr[1]/td[4]/div/div/a[3]/span/span")));
        driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div[6]/div[2]/table/tbody/tr[1]/td[4]/div/div/a[3]/span/span")).click();

    }
}
