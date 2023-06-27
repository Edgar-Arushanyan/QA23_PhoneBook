package com.phonebook.tests;
import com.phonebook.model.Contact;
import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{
    //Создайте, пожалуйста, класс RemoveContactTest, где будет содержаться метод, проверяющий удаление контакта
    //(все остальные действия следует вынести в @BeforeMethod). Попытайтесь написать Assert

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnLoginOutButton();
        }
        app.getHeader().clickOnLoginLink();

        app.getUser().fillLoginRegistrationForm(new User().setEmail("edgar@gmail.com").setPassword("Edgar1234$"));
        app.getUser().clickOnLoginButton();
        app.getHeader().clickOnAddLink();

        app.getContact().fillAddContactForm(new Contact()
                .setName("Karl")
                .setLastname("Adam")
                .setPhone("1234567890")
                .setEmail("adam@gm.com")
                .setAddress("Koblenz")
                .setDesc("goalkepper"));

        app.getContact().clickOnSaveButton();

    }

    @Test
    public void removeContactTest() {

        int sizeBefore = app.getContact().sizeOfContacts();

        app.getContact().removeContact();

        app.getContact().pause(1000);

        int sizeAfter = app.getContact().sizeOfContacts();

        Assert.assertEquals(sizeAfter, sizeBefore-1);

        //Assert.assertTrue(app.getContact().isContactDeleted("Karl"));

    }

}
