package steps;

import page.HomePage;
import page.LoginPage;
import utils.Logger.LoggerUtil;
import utils.Security.ConfigReader;

import static utils.Waits.WaitUtil.waitForSeconds;

public class HomeSteps {

    private final HomePage homePage;

    public HomeSteps() {
        homePage = new HomePage();
    }

    public void validateHome() {
        homePage.waitDashboard();
    }

    public void cerrarConsejosRapidos() {
        if (homePage.existeModalConsejosRapidos()) {
            LoggerUtil.logInfo("Se encontró el modal de consejos rápidos");
            homePage.cerrarModalConsejosRapidos();
            waitForSeconds(1);
            homePage.cerrarModalConsejosRapidos();
            LoggerUtil.logInfo("Se cerró el modal de consejos rápidos");
            waitForSeconds(1);
        }else {LoggerUtil.logInfo("No se encontró el modal de consejos rápidos");}
    }

    public void abrirMenuCursos() {
        homePage.abrirMenuCursos();
        waitForSeconds(1);
    }
}
