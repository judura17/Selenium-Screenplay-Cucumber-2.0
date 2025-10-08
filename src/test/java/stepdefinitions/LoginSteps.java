package stepdefinitions;

import Utils.SharedContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class LoginSteps {

    private final SharedContext context;
    private final WebDriver driver;

    public LoginSteps(SharedContext context){
        this.context = context;
        this.driver = context.getDriver();
    }

    //Dado
    @Given("El usuario esté en la pagina del login")
    public void i_am_on_the_login_page(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("El usuario ingrese las credenciales de usuario y contraseña")
    public void enter_user_and_password(){
        context.getLoginPage().enterUserName("Admin");
        context.getLoginPage().enterPassword("admin123");
        context.getLoginPage().clickLoginButton();
    }

    @Then("El usuario debe de ver el dashboard")
    public void should_watch_the_dashboard(){
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
}
