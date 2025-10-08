package Utils;

import org.example.LoginPage;
import org.example.RecruitmentPage;
import org.openqa.selenium.WebDriver;

public class SharedContext {
    private WebDriver driver;
    private LoginPage loginPage;
    private RecruitmentPage recruitmentPage;

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public RecruitmentPage getRecruitmentPage() {
        if (recruitmentPage == null) {
            recruitmentPage = new RecruitmentPage(driver);
        }
        return recruitmentPage;
    }
}
