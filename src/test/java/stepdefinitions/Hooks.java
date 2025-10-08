package stepdefinitions;

import Utils.SharedContext;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    // Metodo que permite levantar el navegador
    private final SharedContext context;

    public Hooks(SharedContext context){
        this.context = context;
    }

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.setDriver(driver);
    }

    @After
    public void tearDown(){
        if(context.getDriver() != null){
            context.getDriver().quit();
        }
    }
}
