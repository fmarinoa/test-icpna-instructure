package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.HomeSteps;

import static hooks.Hooks.screenShot;

public class HomeStepdefs {

    private final HomeSteps homeSteps;

    public HomeStepdefs() {
        homeSteps = new HomeSteps();
    }

    @Then("valido haber iniciado sesión correctamente")
    public void validoHaberIniciadoSesiónCorrectamente() {
        homeSteps.validateHome();
        screenShot();
    }

    @When("cierro los consejos rápidos")
    public void cierroLosConsejosRápidos() {
        homeSteps.cerrarConsejosRapidos();
        screenShot();
    }

    @And("abro mis cursos")
    public void abroMisCursos() {
        homeSteps.abrirMenuCursos();
        screenShot();
    }
}
