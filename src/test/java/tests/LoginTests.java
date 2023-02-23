package tests;

import manager.ListenerTNG;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Listeners (ListenerTNG.class)

public class LoginTests extends TestBase
{
    @BeforeMethod
    public void preCondition()
    {
        if(app.getHelperUser().isLogged())
        {
            app.getHelperUser().logout();
            logger.info("I need logout");
        }
    }

    @DataProvider
    public Iterator <Object[]> loginData()
    {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"koshka1@mail.ru","Kotic14025$"});
        list.add(new Object[]{"koshka1@mail.ru","Kotic14025$"});
        list.add(new Object[]{"koshka1@mail.ru","Kotic14025$"});

        return list.iterator();
    }

    @Test (dataProvider = "loginData")
    public void loginSuccess(String email, String password)
    {
        logger.info("Login with valid data: Email:" + email + "& Password: " + password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();
        //logout
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Tests success");
    }
    @Test(invocationCount = 2)// kolichestvo zapuskov
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
        logger.info("Error message is : 'Wrong email or password' ");
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
