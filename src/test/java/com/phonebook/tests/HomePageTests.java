package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void openHomePageTest() { //w etom teste wisiwaem metodi nische i proweraem, eto nasiwaetsa musornij kod buler playedKod
        //System.out.println("Home Component is " + isHomeComponentPresent());//budet true esli schto schto estj
        //isElementPresent(By.xpath("//h1[text()='Home Component']"));

        Assert.assertTrue(app.getHomepage().isHomeComponentPresent()); //esli ego net snatschit test ne polnozennij, assert objasatelno
    }


}
