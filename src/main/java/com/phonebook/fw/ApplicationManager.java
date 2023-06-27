package com.phonebook.fw;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class ApplicationManager {//wremennoe nasled na basehelper tolko schtobi metodi tuda skinutj
    String browser;

    public WebDriver driver;

    UserHelper user;
    ContactHelper contact;
    HeaderHelper header;
    HomePageHelper homepage;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public HomePageHelper getHomepage() {
        return homepage;
    }

    public void init() {
        System.err.close();//schtobi wse krasnoe wnisu w outpute ne otobraschalos

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();//initialisazia metodow
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new EdgeDriver(options);
        }

        driver.get("https://telranedu.web.app"); //sajti
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //dast 10 sec wremeni schtobi sajt uspel sagrusitsa, a potom test

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        header = new HeaderHelper(driver);
        homepage = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

}
