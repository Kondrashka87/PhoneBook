package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase
{
    public HelperUser(WebDriver wd)
    {
        super(wd);
    }

    public void openLoginRegistrationForm()
    {
       click(By.cssSelector("[href ^='/lo']"));
    }

    public void fillLoginRegistrationForm(String email, String password)
    {
        type(By.cssSelector("input[name = 'email']"),email);
        type(By.cssSelector("input[name = 'password']"),password);
    }

    public void submitLogin()
    {
        click(By.cssSelector("button:first-of-type"));
    }



}
