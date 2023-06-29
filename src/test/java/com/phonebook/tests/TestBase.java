package com.phonebook.tests;

import com.phonebook.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", Browser.CHROME.browserName()));


    Logger logger = LoggerFactory.getLogger(TestBase.class);

   //@BeforeMethod
    @BeforeSuite(enabled = true)
    public void setUp() {
        app.init();
    }

    //@AfterMethod(enabled = false) to schto w skobkach schtobi bruaser sam ne skriwalsa
    @AfterSuite
    public void tearDown() {
        app.stop();//wichodit is priloschenia polnostju a exit sakriwaet odnu stranizu
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test" + m.getName() + "with data: " + Arrays.asList(p));//protschitaj wse i dobaw w list
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: " +result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: " + result.getMethod().getMethodName() + "Screenshot: "
                    + app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("========================================================");
    }
}
//@BeforeTest (perwij na otscheredi)
   //@BeforeMethod
      //@BeforeClass
         //@BeforeSuite (w odnom brausere)
            //@BeforeGroup (budet poslednim sapuschen)

//(enabled = false) ,  to schto w skobkach schtobi bruaser sam ne skriwalsa;   kak bi sakommentirowan i wremenno ne rabotaet
//(priority = 1) ,  prioritet wnutri klassa


           //@AfterGroups
         //@AfterSuite
      //@AfterClass
   //@AfterMethod
//@AfterTest
