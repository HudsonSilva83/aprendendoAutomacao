package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by hudson on 16/12/2017.
 */
public class LoginFormPage {

    private WebDriver navegador;


    public LoginFormPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public LoginFormPage digiteLogin(String login) {

        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        return this;
    }


    public LoginFormPage digiteSenha(String senha){

        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(senha);
        return this;
    }

    public PaginaSecretaPage clicarSingIn(){
        navegador.findElement(By.linkText("SIGN IN")).click();

        return new PaginaSecretaPage(navegador);
    }


    public PaginaSecretaPage fazerLogin(String login,String senha) {
       digiteLogin(login);
       digiteSenha(senha);
       clicarSingIn();
      return new PaginaSecretaPage(navegador);

    }





}


