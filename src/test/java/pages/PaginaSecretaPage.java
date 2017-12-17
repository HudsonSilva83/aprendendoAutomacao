package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by hudson on 16/12/2017.
 */
public class PaginaSecretaPage extends BasePage{


    public PaginaSecretaPage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clicarMe(){

    navegador.findElement(By.className("me")).click();
    return new MePage(navegador);

}



}
