@Login
Feature: Login in Application

  Background:
    Given estoy en la aplicacion

  @LoginSuccessful
  Scenario Outline: Login successful
    Given escribo el dni "<DNI>"
    And escribo la contraseña
    When doy click en Iniciar sesión
    Then valido haber iniciado sesión correctamente
    Examples:
      | DNI      |
      | 77040901 |

  @LoginWithInvalidPassword
  Scenario Outline: Attempt to log in with an invalid password and verify error message
    Given escribo el dni "<DNI>"
    And escribo la contraseña "<pass>"
    When doy click en Iniciar sesión
    Then valido ver el mensaje de error "<mensajeError>"
    Examples:
      | DNI       | pass      | mensajeError                                                       |
      | user test | pass test | Verifique su nombre de usuario o contraseña, y vuelva a intentarlo |

  @LoginWithoutPassword
  Scenario Outline: Attempt to log in without entering the password and verify error message
    Given escribo el dni "<DNI>"
    When doy click en Iniciar sesión
    Then valido ver el mensaje de error "<mensajeError>"
    Examples:
      | DNI      | mensajeError        |
      | 77040901 | Contraseña inválida |