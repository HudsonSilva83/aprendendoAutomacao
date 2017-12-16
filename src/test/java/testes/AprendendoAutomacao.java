package testes;
//import Suporte.Generator;
//import Suporte.Screenshot;
import Suporte.Generator;
import Suporte.Screenshot;
import org.apache.http.util.Asserts;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 * Created by hudson on 15/12/2017.
 */

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "AprendendoAutomacao.csv")

public class AprendendoAutomacao    {

        private WebDriver navegador;
        @Rule

        public TestName arquivo = new TestName();


        @Before
        public void setup(){


            System.setProperty("webdriver.chrome.driver","C:\\test\\chromedriver.exe");
            navegador = new ChromeDriver();
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            navegador.manage().window().maximize();
            navegador.get("https://juliodeLima.com.br/taskit");
            //Assert.assertEquals("","");
            navegador.findElement(By.linkText("Task it!")).click();
            navegador.findElement(By.linkText("Sign in")).click();

            WebElement formulario = navegador.findElement(By.id("signinbox"));

            formulario.findElement(By.name("login")).sendKeys("julio0001");
            formulario.findElement(By.name("password")).sendKeys("123456");
            navegador.findElement(By.linkText("SIGN IN")).click();
            navegador.findElement(By.className("me")).click();
            navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        }


        @Test
        public void testCadastrarContaUsuario(@Param(name="tipo")String tipo,@Param(name="contato") String contato,
                                              @Param(name= "mensagem") String mensagemEsperada){



            navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
            WebElement popup = navegador.findElement(By.id("addmoredata"));
            WebElement campoType = popup.findElement(By.name("type"));
            new Select(campoType).selectByVisibleText(tipo);
            navegador.findElement(By.name("contact")).sendKeys(contato);
            navegador.findElement(By.linkText("SAVE")).click();
            //aqui foi cadastrado com sucesso
            WebElement texto = navegador.findElement(By.id("toast-container"));
            String mensagem = texto.getText();
            System.out.print(mensagem);
            Assert.assertEquals(mensagemEsperada,mensagem);

            //pegando o print da tela após cadastrar

            String screanshotArqCadastro = "/Users/hudson/Desktop/Evidencias/" + Generator.dataHoraParaArquivo()
                    + arquivo.getMethodName() + ".png";
            Screenshot.printar(navegador,screanshotArqCadastro);

            navegador.quit();

        }

        //@Test

        public void removerContaUsuario() {
            navegador.findElement(By.xpath("//span[text()=\"+553112345658\"]/following-sibling::a")).click();
            navegador.switchTo().alert().accept();
            WebElement texto = navegador.findElement(By.id("toast-container"));
            String miguel = texto.getText();
            System.out.print(miguel);
            Assert.assertEquals("Rest in peace, dear phone!",miguel);

            String screanshotArqremover = "/Users/hudson/Desktop/Evidencias/" + Generator.dataHoraParaArquivo()
                    + arquivo.getMethodName() + ".png";
            Screenshot.printar(navegador,screanshotArqremover);

            WebDriverWait aguardar = new WebDriverWait(navegador,10);
            aguardar.until(ExpectedConditions.stalenessOf(texto));

            navegador.findElement(By.linkText("Logout")).click();

        }


        @After

        public void fechar(){

            navegador.quit();
        }


    }


