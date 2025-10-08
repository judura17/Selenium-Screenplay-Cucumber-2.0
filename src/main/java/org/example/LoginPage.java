package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage extends BasePage{
    // Constructor que hereda de la clase BasePage
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Elementos de la pagina del login
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    //Metodos de interaccion de la clase login
    public void enterUserName(String username) {
        waitForElement(usernameField, Duration.ofSeconds(30));
        type(usernameField, username);
    }

    public void enterPassword(String password){
        type(passwordField, password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }
}
