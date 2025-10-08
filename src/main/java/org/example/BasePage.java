package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;

    }

    //Metodos de interaccion
    //Encontrar elementos en pantalla
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    //Escribir texto
    public void type(By locator, String inputText) {
        findElement(locator).sendKeys(inputText);
    }

    //Hacer clic a un elemento
    public void click(By locator){
        findElement(locator).click();
    }

    //Esperar a que un elemento este presente en pantalla
    public void waitForElement(By locator, Duration timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    // Funcion para simular la pulsacion de teclas: DOWN + ENTER
    public void pressDownAndEnter(By locator) {
        findElement(locator);
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    // Funcion para establecer una espera implicita
    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    // Obtener texto de un elemento
    public String getText(By locator) {
        return findElement(locator).getText();
    }

}
