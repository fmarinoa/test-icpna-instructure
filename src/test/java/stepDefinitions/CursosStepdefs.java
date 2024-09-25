package stepDefinitions;

import io.cucumber.java.en.And;
import steps.CursosSteps;

import static hooks.Hooks.screenShot;

public class CursosStepdefs {

    private final CursosSteps cursosSteps;

    public CursosStepdefs() {
        cursosSteps = new CursosSteps();
    }

    @And("selecciono mi curso {string}")
    public void seleccionoMiCurso(String arg0) {
        cursosSteps.seleccionarCurso(arg0);
        screenShot();
    }
}
