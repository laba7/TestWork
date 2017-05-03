package com.work.test;

import com.work.test.util.logging.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 30.04.2017.
 */
public abstract class BaseTest {

    protected EventFiringWebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected AfterLoginPage afterLoginPage;
    protected CreateAds createAds;
    protected AdvertisingPage advertisingPage;
    protected SuccessAdd successAdd;
    protected AdsPage adsPage;

    /**
     *
     * @param browser Driver type to use in tests.
     *
     * @return New instance of {@link WebDriver} object.
     */
    private WebDriver getDriver(String browser) {
        switch (browser) {
            case "firefox":
                System.setProperty(
                        "webdriver.gecko.driver",
                        getResource("/geckodriver.exe"));
                return new FirefoxDriver();
            case "ie":
            case "internet explorer":
                System.setProperty(
                        "webdriver.ie.driver",
                        getResource("/IEDriverServer.exe"));
                return new InternetExplorerDriver();
            case "chrome":
            default:
                System.setProperty(
                        "webdriver.chrome.driver",
                        getResource("/chromedriver.exe"));
                return new ChromeDriver();
        }
    }

    /**
     * @param resourceName The name of the resource
     * @return Path to resource
     */
    private String getResource(String resourceName) {
        try {
            return Paths.get(BaseTest.class.getResource(resourceName).toURI()).toFile().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return resourceName;
    }

    /**
     * Prepares {@link WebDriver} instance with timeout and browser window configurations.
     *
     * Driver type is based on passed parameters to the automation project,
     * creates {@link ChromeDriver} instance by default.
     *
     */
    @BeforeClass
    @Parameters({"browser"})
    // TODO use parameters from pom.xml to pass required browser type
    public void setUp(@Optional("chrome") String browser ) {
//        browser = "chrome";
        driver = new EventFiringWebDriver(getDriver(browser));
        driver.register(new EventHandler());

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        afterLoginPage = new AfterLoginPage(driver);
        createAds = new CreateAds(driver);
        advertisingPage = new AdvertisingPage(driver);
        successAdd = new SuccessAdd(driver);
        adsPage = new AdsPage(driver);
    }

    /**
     * Closes driver instance after test class execution.
     */
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
