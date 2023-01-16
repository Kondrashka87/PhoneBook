package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    @BeforeMethod
    public void preCondition()
    {
        if(app.getHelperUser().isLogged())
        {
            app.getHelperUser().logout();
        }
    }
    @Test
    public void loginSuccess()
    {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("koshka1@mail.ru","Kotic14025$");
        app.getHelperUser().submitLogin();
        //logout
        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void loginSuccessNew()// drugo' pol'zovatel'
    {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("koshka1@mail.ru","Kotic14025$");
        app.getHelperUser().submitLogin();
        //logout
        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void loginWrongEmail()
    {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("koshka1mail.ru","Kotic14025$");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));

    }
    @Test
    public void loginWrongPassword()
    {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("koshka@1mail.ru","Kotic025$");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));
    }
    @Test
    public void loginUnregisterUser()
    {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("doshka1mail.ru","Kotic14025$");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));
    }






}
