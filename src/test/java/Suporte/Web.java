package Suporte;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by hudson on 16/12/2017.
 */
public class Web {

    public static WebDriver createChrome(){

        System.setProperty("webdriver.chrome.driver","C:\\test\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();
        navegador.get("https://juliodeLima.com.br/taskit");
        navegador.findElement(By.linkText("Task it!")).click();

       return navegador;

    }


}
