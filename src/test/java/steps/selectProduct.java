package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class selectProduct {
    // Atributos
    WebDriver driver;

    @BeforeAll // Execute anets de todos os blocos de passos --> usar do Cucumber
    public void setUp(){
        ChromeOptions options = new ChromeOptions(); // instancia o objeto de Opções do ChomeDriver
        options.addArguments("--remote-allow-origins=*"); // Permite qualquer origem remota
        WebDriverManager.chromedriver().setup(); // baixar a versão mais atual do ChromeDriver
        driver = new ChromeDriver(options); // instancia o objeto do Selenium como ChromeDriver

        // Estabele um espera implicita de 5 segundos para carrgar qualquer elemento
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().window().maximize(); // Maximiza a janela do navegador
    }

    @AfterAll // executa após os blocos de passos --> usar do Cucumber
    public void tearDown(){
        driver.quit();   // Encerrar o objeto do Selenium WebDriver
    }

    @Given("I access SauceDemo store")
    public void i_access_sauce_demo_store() {

    }
    @When("I filled a user {string} and {string}")
    public void i_filled_a_user_and(String string, String string2) {

    }
    @And("I click in login")
    public void i_click_in_login() {

    }
    @Then("show pag's title {string}")
    public void show_pag_s_title(String string) {

    }
    @And("show cart's link")
    public void show_cart_s_link() {

    }
    @When("I click in product {string}")
    public void i_click_in_product(String string) {

    }
    @Then("I verify the product title {string}")
    public void i_verify_the_product_title(String string) {

    }
    @And("I verify the product price {string}")
    public void i_verify_the_product_price(String string) {

    }
    @When("I click in Add to Cart")
    public void i_click_in_add_to_cart() {

    }
    @And("I click in Cart icon")
    public void i_click_in_cart_icon() {

    }
    @Then("I verify the page's title {string}")
    public void i_verify_the_page_s_title(String string) {

    }
    @And("I verify the quantity is {string}")
    public void i_verify_the_quantity_is(String string) {

    }
}
