package com.work.test;

import com.work.test.util.logging.CustomReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 30.04.2017.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void login(String login, String password) {
        CustomReporter.log("Login as user - " + login);

        driver.findElement(By.id("userEmail")).sendKeys(login);
        driver.findElement(By.id("userPass")).sendKeys(password);
        driver.findElement(By.id("se_userLogin")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("myaccountview")));

    }
}
