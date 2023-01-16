package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public boolean isLogged()
    {
        List <WebElement> list = wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return list.size() > 0;
    }

    public void logout()
    {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isErrorMessageDisplayed(String message)
    {
        Alert alert = wd.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        alert.accept(); //klik na OK
//        alert.dismiss();//klik na cancel
//        alert.sendKeys("Hello");// vvod stroki
        return text.contains(message);
    }

    public void submitRegistration()
    {
        click(By.cssSelector("button:last-child"));
    }



}
