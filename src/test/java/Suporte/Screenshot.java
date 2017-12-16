package Suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {

    public static void printar(WebDriver navegador,String arquivo) {

        File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(screenshot,new File(arquivo));

        try {

            FileUtils.copyFile(screenshot, new File(arquivo));
        }catch (Exception e){

        System.out.println("Houveram problemas ao copiar o aqruivo para a pasta" + e.getMessage());

        }

    }
}