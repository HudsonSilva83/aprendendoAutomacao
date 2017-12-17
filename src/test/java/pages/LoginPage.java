package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by hudson on 16/12/2017.
 */
public class LoginPage extends BasePage{


    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage clickSingIn (){
        navegador.findElement(By.linkText("Sign in")).click();
        return new LoginFormPage(navegador);




    }

}
