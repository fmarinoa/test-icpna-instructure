package steps;

import org.junit.Assert;
import page.LoginPage;
import utils.Logger.LoggerUtil;
import utils.Security.ConfigReader;


public class LoginSteps {

    private final LoginPage loginPage;
    private final ConfigReader configReader;


    public LoginSteps() {
        loginPage = new LoginPage();
        configReader = new ConfigReader();
    }

    public void goToApp() {
        loginPage.goICPNA();
        LoggerUtil.logInfo("Enté al login de ICPNA");
        loginPage.waitFormLogin();
        LoggerUtil.logInfo("Existe el formulario de Login");
    }

    public void sendDNI(String arg0) {
        loginPage.sendDNI(arg0);
        LoggerUtil.logInfo("Escribí el DNI: " + arg0);
    }

    public void sendPassEncripter() {
        String password = configReader.getPassword();
        loginPage.sendPassWord(password);
        LoggerUtil.logInfo("Escribí la contraseña: " + password);
    }

    public void clickIniciarSesion() {
        loginPage.clickInciarSesion();
        LoggerUtil.logInfo("Dí click en el botón de inicar sesión");
    }

    public void validarMensajeError(String expectedText) {
        String currentText = loginPage.getMensajeError();
        LoggerUtil.logInfo("Mensaje de error obtenido: " + currentText);
        Assert.assertTrue("El mensaje de error no contiene el texto esperado", currentText.contains(expectedText));
    }

    public void sendPass(String arg0) {
        loginPage.sendPassWord(arg0);
        LoggerUtil.logInfo("Escribí la contraseña: " + arg0);
    }
}
