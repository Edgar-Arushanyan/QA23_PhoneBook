package com.phonebook.tests;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {//esli etogo ne suschestwuet snatschit ti usche saloginilsa
            app.getHeader().clickOnLoginOutButton();
        }
        //click Login link
        app.getHeader().clickOnLoginLink();
    }

    @Test(priority = 1)
    public void loginPositiveTest() {

        //enter email field
        app.getUser().fillLoginRegistrationForm(new User().setEmail("edgar@gmail.com").setPassword("Edgar1234$"));

        //click on Registration
        app.getUser().clickOnLoginButton();

        //assert user logged in(check Sign out button displayed) kogda salogen to pojawlaetsa pole sign out
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());//pri wtorom prohode test prowalitsa potomuschto dwa rasa s odnimi i temi sce dannimi nelsa saregitsa
    }

    @Test
    public void loginNegativeWithoutPasswordTest() {

        //enter email field
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("edgar@gmail.com"));
        //click on Registration
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
