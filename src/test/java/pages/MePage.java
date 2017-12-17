package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by hudson on 16/12/2017.
 */
public class MePage extends BasePage{

    public MePage(WebDriver navegador) {
        super(navegador);
    }
public MePage clicarAbaMoreDateAbout(){
    navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        return this;
}

public AdContatoPage cliarAdConta(){
    navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

    return new AdContatoPage(navegador);
}


}
