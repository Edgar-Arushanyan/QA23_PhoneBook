package com.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent1(By.xpath("//h1[text()='Home Component']"));
        //esli bolsche 0 ubedimsa schto element totschno suschestwuet
    }
}
