package stepdefinitions;

import Utils.SharedContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.RecruitmentPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecruitmentSteps {

    private final SharedContext context;
    private LoginSteps loginSteps;
    private RecruitmentPage recruitmentPage;

    public RecruitmentSteps(SharedContext context){
        this.context = context;
    }

    //Dado
    @Given("Este logueado en la aplicacion")
    public void login_into_application(){
        recruitmentPage = new RecruitmentPage(context.getDriver());
        loginSteps = new LoginSteps(context);
        loginSteps.i_am_on_the_login_page();
        loginSteps.enter_user_and_password();
        loginSteps.should_watch_the_dashboard();
    }

    //Cuando
    @When("Ingrese al portal de reclutamiento")
    public void select_the_recruitment_menu() throws InterruptedException {
        Thread.sleep(5000);
        recruitmentPage.clickMenuRecruitment();
    }

    //Y
    @And("Postule el candidato")
    public void the_candidate_will_be_postulate(){
        //Proceso de postulacion
        recruitmentPage.clickAddButton();
        recruitmentPage.typeFirstName("Oscar");
        recruitmentPage.typeMiddleName("Julian");
        recruitmentPage.typeLastName("Duque Ramos");
        recruitmentPage.clickSelectVacancy();
        recruitmentPage.typeEmail("test@prueba.com");
        recruitmentPage.typeContactNumber("3126980000");
        recruitmentPage.uploadResume("C:\\Users\\OSJUDURA\\Documents\\Proyectos\\RecruitPeople\\src\\test\\resources\\Curriculum.txt");
        recruitmentPage.typeKeywords("Responsabiliad, disciplina");
        recruitmentPage.clickDateCalendar();
        recruitmentPage.clickChooseToday();
        recruitmentPage.clickSaveButton();
    }
    //Y
    @And("Agende la entrevista")
    public void the_intreview_is_scheduled() throws InterruptedException {
        recruitmentPage.clickShortListButton();
        recruitmentPage.clickSaveButton();
        recruitmentPage.clickScheduleIntreviewButtons();
        recruitmentPage.typeIntreviewTittle("Test QA");
        recruitmentPage.typeIntreviewer("a");
        Thread.sleep(5000);
        recruitmentPage.clickChooseIntreviewer();
        recruitmentPage.typeChooseDateIntreview("2025-31-12");
        recruitmentPage.typeFieldTime("08:00 AM");
        recruitmentPage.clickSaveButton();
        recruitmentPage.clickIntreviewPassed();
        recruitmentPage.clickSaveButton();
        recruitmentPage.clickOfferJob();
        recruitmentPage.clickSaveButton();
        recruitmentPage.clickHire();
        recruitmentPage.clickSaveButton();
        assertEquals(recruitmentPage.getStatusMessage(""), "Status: Hired");
        recruitmentPage.clickMenuRecruitment();
    }
    //Luego
    /*
    @Then("Valida el postulado como contratado")
    public void postulate_as_a_hired(){
        recruitmentPage.checkStatusOnRow();
    }*/
    @Then("El candidato {string} debe tener el estado {string}")
    public void candidate_should_have_status(String candidateName, String expectedStatus) {
        recruitmentPage = new RecruitmentPage(context.getDriver());
        boolean result = recruitmentPage.isCandidateWithStatusPresent(candidateName, expectedStatus);
        assertTrue("El candidato " + candidateName + " no tiene el estado esperado: " + expectedStatus, result);
    }

}
