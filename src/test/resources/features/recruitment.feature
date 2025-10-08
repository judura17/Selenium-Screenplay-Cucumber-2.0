@Recruitment
Feature: Recruitment

  Scenario: Login y luego registrar candidato
    Given Este logueado en la aplicacion
    When Ingrese al portal de reclutamiento
    And Postule el candidato
    And Agende la entrevista
    Then El candidato "Oscar Julian Duque Ramos" debe tener el estado "Hired"