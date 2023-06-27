package com.phonebook.tests;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //precondition:(predislowie) user should be logged out(rasloginen dolschen bitj polsowatelj)
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {     //esli etogo ne suschestwuet snatschit ti usche saloginilsa
            app.getHeader().clickOnLoginOutButton();
        }
        //click Login link
        app.getHeader().clickOnLoginLink();     //saloginilisj click button Login metod click opisan nische
    }

    @Test
    public void existedUserRegistrationNegativeTest() {

        //enter email field
        // enter password field
        app.getUser().fillLoginRegistrationForm(new User().setEmail("edgar@gmail.com").setPassword("Edgar1234$"));

        //click on Registration
        app.getUser().clickOnRegistrationButton();

        //assert user logged in(check Sign out button displayed) kogda salogen to pojawlaetsa pole sign out
        Assert.assertTrue(app.getUser().isAlertPresent());//pri wtorom prohode test prowalitsa potomuschto dwa rasa s odnimi i temi sce dannimi nelsa saregitsa
    }


}
