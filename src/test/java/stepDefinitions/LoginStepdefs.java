package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.LoginSteps;

import static hooks.Hooks.screenShot;

public class LoginStepdefs {

    private final LoginSteps loginSteps;

    public LoginStepdefs() {
        loginSteps = new LoginSteps();
    }

    @Given("estoy en la aplicacion")
    public void estoyEnLaAplicacion() {
        loginSteps.goToApp();
        screenShot();
    }

    @Given("escribo el dni {string}")
    public void escriboElDni(String arg0) {
        loginSteps.sendDNI(arg0);
        screenShot();
    }

    @And("escribo la contraseña")
    public void escriboLaContraseña() {
        loginSteps.sendPassEncripter();
        screenShot();
    }

    @When("doy click en Iniciar sesión")
    public void doyClickEnIniciarSesión() {
        loginSteps.clickIniciarSesion();
    }

    @Then("valido ver el mensaje de error {string}")
    public void validoVerElMensajeDeError(String arg0) {
        loginSteps.validarMensajeError(arg0);
        screenShot();
    }

    @And("escribo la contraseña {string}")
    public void escriboLaContraseña(String arg0) {
        loginSteps.sendPass(arg0);
        screenShot();
    }
}
