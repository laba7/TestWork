package com.work.test.tests;

import com.work.test.BaseTest;
import org.testng.annotations.Test;
/**
 * Created by User on 30.04.2017.
 */
public class CreateAd extends BaseTest {

    private String name = "StarCars";
    private String price = "75000";
    private String descr = "Лучшие баги Украины и Европы.";
    private String number = "0667437823";

    @Test
    public void createNewAd(){
    homePage.profile();
    loginPage.login("oleglaba97@gmail.com", "testTest");
        afterLoginPage.buttonNewAd();
        createAds.getName(name);
        createAds.selectCategory();

    }

        @Test(dependsOnMethods = "createNewAd")
    public void checkAd() throws InterruptedException {
            Thread.sleep(6000l);
//            createAds.getPrice(price);
            createAds.privateOrBusiness();
            createAds.description(descr);
            createAds.numderPhone(number);
            createAds.buttonNext();
            advertisingPage.addAdvertising();
            successAdd.controlAd();
            adsPage.deleteAds();
    }
}
