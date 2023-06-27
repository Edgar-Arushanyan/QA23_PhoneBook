package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{
    //В проекте создать новый класс HeaderTests и в нем 4 метода, которые будут проверять наличие элементов
    // в навигационной панели(логотип, HOME, ABOUT и LOGIN) dlja nesareg. pols. testit nalitschie etich knopok
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnLoginOutButton();
        }
        app.getHeader().clickOnLoginLink();
    }

    @Test
    public void logo() {
         Assert.assertTrue(app.getHeader().isLogoPresent());
    }

    @Test
    public void HOME() {
        Assert.assertTrue(app.getHeader().isHomeLinkPresent());
    }

    @Test
    public void ABOUT() {
        Assert.assertTrue(app.getHeader().isAboutLinkPresent());
    }

    @Test
    public void LOGIN() {
        Assert.assertTrue(app.getHeader().isLoginLinkPresent());
    }
}
