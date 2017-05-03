package com.work.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 02.05.2017.
 */
public class CreateAds {

    private WebDriver driver;
    private WebDriverWait wait;
    private By phone = By.cssSelector("#add-phone");


    public CreateAds(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 90);
    }

    public void getName(String name){
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("addingview")));
        WebElement inputName = driver.findElement(By.id("add-title"));
        inputName.sendKeys(name);
    }

    public void selectCategory(){
        driver.findElement(By.id("targetrenderSelect1-0")).click();
        driver.findElement(By.id("cat-3")).click();
//        driver.findElement(By.className("icon-list block rel lheight16 tdnone clr")).click();
        WebElement disks = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/ul/li[6]/a/span[1]"));
        disks.click();
    }

    public void getPrice(String price){
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("text x-normal br3 light min price paramPriceInput fleft marginleft10")));xpath("input.text.x-normal.br3.light.min.price.paramPriceInput.fleft.marginleft10"))
        WebElement price1 = driver.findElement(By.className("text x-normal br3 light min price paramPriceInput fleft marginleft10"));
        price1.sendKeys(price);
    }

    public void privateOrBusiness(){
        WebElement or = driver.findElement(By.id("targetid_private_business"));
        or.click();
        WebElement priv =  driver.findElement(By.xpath("/html/body/div[1]/section/div/div/form/fieldset[1]/div[3]/div[3]/div[2]/div/dl/dd/ul/li[2]/a"));
        priv.click();
    }

    public void description(String descr){
        driver.findElement(By.id("add-description")).sendKeys(descr);
    }

    public void numderPhone(String number){
        WebElement phone = driver.findElement(this.phone);
//        phone.click();
        phone.clear();
        phone.sendKeys(number);
    }

    public void buttonNext(){
        driver.findElement(By.id("save")).click();
    }

}
