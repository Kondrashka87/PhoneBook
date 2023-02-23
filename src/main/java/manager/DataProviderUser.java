package manager;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser
{
    @DataProvider
    public Iterator<Object[]> loginDataCls()
    {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"koshka1@mail.ru","Kotic14025$"});
        list.add(new Object[]{"koshka1@mail.ru","Kotic14025$"});
        list.add(new Object[]{"koshka1@mail.ru","Kotic14025$"});

        return list.iterator();
    }

    @Test(dataProvider = "loginData")
    public void loginSuccess2(String email, String password)
    {
        logger.info("Login with valid data: Email:" + email + "& Password: " + password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();
        //logout
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Tests success");
    }














}
