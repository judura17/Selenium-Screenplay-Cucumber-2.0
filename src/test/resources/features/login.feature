@Login
Feature: Login

  Scenario: Login exitoso con credenciales validas
    Given El usuario esté en la pagina del login
    When El usuario ingrese las credenciales de usuario y contraseña
    Then El usuario debe de ver el dashboard