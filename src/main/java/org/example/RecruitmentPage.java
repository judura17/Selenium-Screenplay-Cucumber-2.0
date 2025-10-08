package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class RecruitmentPage extends BasePage{

    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }
    // Elementos de la pagina de recruitment
    private By menuRecruitment = By.xpath("//span[text()='Recruitment']");
    private By addButton = By.xpath("//button[contains(.,'Add')]");
    private By fieldFirstName = By.xpath("//input[@name='firstName']");
    private By fieldMiddleName = By.xpath("//input[@name='middleName']");
    private By fieldLastName = By.xpath("//input[@name='lastName']");
    private By selectVacancy = By.xpath("//*[@class='oxd-select-text-input']");
    private By selectOptionPA = By.xpath("//*[text()='Payroll Administrator']");
    private By fieldEmail = By.xpath("//label[contains(text(), 'Email')]//following::input");
    private By fieldContactNumber = By.xpath("//label[contains(text(), 'Contact Number')]//following::input");
    private By fileUpload = By.xpath("//input[@type='file']");
    private By fieldKeywords = By.xpath("//label[contains(.,'Keywords')]//following::input");
    private By dateCalendar = By.xpath("//input[@placeholder='yyyy-dd-mm']");
    private By chooseToday = By.xpath("//div[@class='oxd-date-input-link --today']");
    private By saveButton = By.xpath("//button[@type='submit']");
    private By shortListButton = By.xpath("//button[normalize-space()='Shortlist']");
    private By scheduleIntreviewButtons = By.xpath("//button[contains(.,' Schedule Interview ')]");
    private By fieldIntreviewTittle = By.xpath("//label[contains(.,'Interview Title')]//following::input");
    private By fieldIntreviewer = By.xpath("//label[contains(.,'Interviewer')]//following::input");
    private By chooseIntreviewer = By.xpath("//label[contains(.,'Interviewer')]//following::input");
    private By chooseDateIntreview = By.xpath("//input[@placeholder='yyyy-dd-mm']");
    private By fieldTime = By.xpath("//input[@placeholder='hh:mm']");
    private By intreviewPassedButton = By.xpath("//button[normalize-space()='Mark Interview Passed']");
    private By offerJobButton = By.xpath("//button[normalize-space()='Offer Job']");
    private By hireButton = By.xpath("//button[normalize-space()='Hire']");
    private By statusMessage = By.xpath("//p[contains(.,'Status: Hired')]");
    private By rowSearch = By.xpath("//div[@role='row']");
    private By tableBody = By.xpath("//div[@class='oxd-table-body']");
    private By tableRows = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']");

    // Metodos de interaccion de la pagina recruitment
    public void clickMenuRecruitment(){
        waitForElement(menuRecruitment, Duration.ofSeconds(30));
        click(menuRecruitment);
    }
    public void clickAddButton(){
        waitForElement(addButton, Duration.ofSeconds(30));
        click(addButton);
    }
    public void typeFirstName(String firstName){
        waitForElement(fieldFirstName, Duration.ofSeconds(30));
        type(fieldFirstName, firstName);
    }
    public void typeMiddleName(String middleName){
        type(fieldMiddleName, middleName);
    }
    public void typeLastName(String lastName){
        type(fieldLastName, lastName);
    }
    public void clickSelectVacancy(){
        click(selectVacancy);
        waitForElement(selectOptionPA, Duration.ofSeconds(30));
        click(selectOptionPA);
    }
    public void typeEmail(String email){
        type(fieldEmail,email);
    }
    public void typeContactNumber(String contactNumber){
        type(fieldContactNumber, contactNumber);
    }
    public void uploadResume(String pathFile){
        setImplicitWait(5);
        type(fileUpload,pathFile);
    }
    public void typeKeywords(String keyWords){
        type(fieldKeywords,keyWords);
    }
    public void clickDateCalendar(){
        click(dateCalendar);
    }
    public void clickChooseToday(){
        waitForElement(chooseToday, Duration.ofSeconds(30));
        click(chooseToday);
    }
    public void clickSaveButton(){
        waitForElement(saveButton, Duration.ofSeconds(30));
        click(saveButton);
    }
    public void clickShortListButton(){
        waitForElement(shortListButton,Duration.ofSeconds(30));
        click(shortListButton);
    }
    public void clickScheduleIntreviewButtons(){
        waitForElement(scheduleIntreviewButtons, Duration.ofSeconds(30));
        click(scheduleIntreviewButtons);
    }
    public void typeIntreviewTittle(String intreviewTittle){
        type(fieldIntreviewTittle, intreviewTittle);
    }
    public void typeIntreviewer(String intreviewer){
        type(fieldIntreviewer, intreviewer);
        setImplicitWait(5);
    }
    public void clickChooseIntreviewer(){
        pressDownAndEnter(chooseIntreviewer);
    }
    public void typeChooseDateIntreview(String dateIntreview){
        type(chooseDateIntreview, dateIntreview);
    }
    public void typeFieldTime(String time){
        type(fieldTime, time);
    }
    public void clickIntreviewPassed(){
        waitForElement(intreviewPassedButton, Duration.ofSeconds(30));
        click(intreviewPassedButton);
    }
    public void clickOfferJob(){
        waitForElement(offerJobButton, Duration.ofSeconds(30));
        click(offerJobButton);
    }
    public void clickHire(){
        waitForElement(hireButton, Duration.ofSeconds(30));
        click(hireButton);
    }
    public String getStatusMessage(String message){
        waitForElement(statusMessage, Duration.ofSeconds(30));
        return getText(statusMessage);
    }
    public void checkStatusOnRow(){
        waitForElement(statusMessage, Duration.ofSeconds(30));

    }
    //Metodo para validar si un candidato con cierto nombre tiene un status especifico

    public boolean isCandidateWithStatusPresent(String candidateName, String expectedStatus) {
        // Espera que cargue la tabla de candidatos
        waitForElement(tableBody, Duration.ofSeconds(20));

        List<WebElement> rows = driver.findElements(tableRows);

        for (WebElement row : rows) {
            String rowText = row.getText();

            // Verifica si la fila contiene el nombre del candidato
            if (rowText.contains(candidateName)) {
                try {
                    // Encuentra la celda del estado. El -1 es para acceder al penultimo elemento dentro del div
                    WebElement statusCell = row.findElement(By.xpath(".//div[@role='cell'][last()-1]"));
                    String actualStatus = statusCell.getText().trim();

                    System.out.println("Candidato encontrado: " + candidateName + " | Estado: " + actualStatus);

                    return actualStatus.equalsIgnoreCase(expectedStatus);
                } catch (Exception e) {
                    System.out.println("No se pudo obtener el estado para el candidato: " + candidateName);
                    return false;
                }
            }
        }

        System.out.println("No se encontro el candidato: " + candidateName);
        return false;
    }

}
