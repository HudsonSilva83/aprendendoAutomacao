package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hudson on 16/12/2017.
 */
public class BasePage {

    protected WebDriver navegador;

    public BasePage(WebDriver navegador){
        this.navegador = navegador;

    }

    public String MensagemCapturada(){

        return navegador.findElement(By.id("toast-container")).getText();

    }
}
