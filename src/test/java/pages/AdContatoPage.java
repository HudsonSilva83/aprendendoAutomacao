package pages;

import org.easetech.easytest.annotation.Param;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by hudson on 16/12/2017.
 */
public class AdContatoPage extends BasePage{
    public AdContatoPage(WebDriver navegador) {
        super(navegador);
    }

    public AdContatoPage escolherTipoContato(String tipo){
        WebElement popup = navegador.findElement(By.id("addmoredata"));
        WebElement campoType = popup.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        return this;
    }

    public  AdContatoPage digitarContato(String contato){

        navegador.findElement(By.name("contact")).sendKeys(contato);

        return this;
    }

    public AdContatoPage SalvarContato(){

        navegador.findElement(By.linkText("SAVE")).click();
        return this;

}

public AdContatoPage AdicionarContato(String tipo,String contato){
        escolherTipoContato(tipo);
        digitarContato(contato);
        SalvarContato();




        return this;
}




}
