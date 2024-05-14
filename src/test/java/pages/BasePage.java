package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

     // Função para retornar o título escrito na guia do browser
     public String lerTituloGuia(){
        return driver.getTitle();
     }
}
