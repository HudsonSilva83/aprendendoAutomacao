package testes;

import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;

/**
 * Created by hudson on 16/12/2017.
 */


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LogarPageObjectsTest.csv")

public class LogarPageObjectsTest {
    private WebDriver navegador;

@Before
    public void setup(){

    navegador = Web.createChrome();

}


@Test
    public void testAdicionarInformacaoAdicionalUsuario(@Param(name="tipo")String tipo, @Param(name="contato") String contato,
                                                        @Param(name= "mensagem") String mensagemEsperada){
    BasePage mensa = new BasePage(navegador);

     new LoginPage(navegador)
     .clickSingIn()
     .fazerLogin("julio0001","123456")
     .clicarMe()
     .clicarAbaMoreDateAbout()
     .cliarAdConta()
      .escolherTipoContato(tipo)
      .digitarContato(contato)
      .SalvarContato()
       .MensagemCapturada();

    Assert.assertEquals(mensagemEsperada,mensa.MensagemCapturada());

  navegador.quit();


}

@After
    public void Fechar(){


}


}
