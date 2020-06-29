package program;

import email.Config;
import email.SendMail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void nexxera() {

        try {
            driver.get("http://appsdevops.tk");
            Thread.sleep(5000);
            driver.switchTo().frame(0);
            String elemento = driver.findElement(By.xpath("//pre[@style='word-wrap: break-word; white-space: pre-wrap;']")).getText();
            System.out.println(elemento);

            String[] arrayDeNomes = elemento.split(", ");
            for (String nome : arrayDeNomes)
                if (nome.equals("\"mongo\": \"down\"")) {
                    Config.loadConfig();
                    String subject = "Serviço indisponível";
                    String text = "Nosso time está trabalhando para que o serviço seja reestabelecido o mais breve possível. Atenciosamente, Time de desenvolvimento e Infra!";
                    SendMail sendMail = new SendMail();
                    sendMail.send(subject, text);
                }
            System.out.println();
            System.out.println("Verificação completa. Serviço está indisponível!");
        } catch (Exception e){
            System.out.println("Teste falhou. Possíveis causas:");
            System.out.println("1 - Verificar disponibilidade do site;");
            System.out.println("2 - Verificar config.properties se está configurado com email e senha corretos;");
            System.out.println("3 - Verificar se o arquivo javax.mail-1.6.2.jar está instalado corretamente na biblioteca;");
            System.out.println("4 - Verificar se importações de classes estão corretas.");
            System.out.println();
            System.out.println("Teste realizado e homologado com Java 1.8 + IntelliJ Ultimate 2019.3 + Junit 4.12 + maven 3.6.0.");
        }

    }
}