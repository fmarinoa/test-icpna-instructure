package page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static hooks.Hooks.getDriver;
import static utils.Waits.WaitUtil.waitElementIsClickable;
import static utils.Waits.WaitUtil.waitElementIsVisibility;

public class LoginPage extends BasePage {

    @FindBy(className = "ic-Login__content")
    protected WebElement formLogin;

    @FindBy(xpath = "//input[@id='pseudonym_session_unique_id']")
    protected WebElement inputDNI;

    @FindBy(xpath = "//input[@id='pseudonym_session_password']")
    protected WebElement inputPassword;

    @FindBy(xpath = "//input[@type='submit']")
    protected WebElement btnIniciarSesion;

    @FindBy(xpath = "(//div[@class='error_text'])[2] | //*[@id='flash_message_holder']/div")
    protected WebElement lblMensajeError;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this); // Inicializa los elementos
    }

    public void goICPNA() {
        getUrl("https://icpna.instructure.com/login/canvas");
    }

    public void waitFormLogin() {
        waitElementIsVisibility(formLogin, 30);
    }

    public void sendDNI(String dni) {
        waitElementIsVisibility(inputDNI, 30);
        sendText(inputDNI, dni);
    }

    public void sendPassWord(String pass) {
        waitElementIsVisibility(inputPassword, 30);
        sendText(inputPassword, pass);
    }

    public void clickInciarSesion() {
        waitElementIsClickable(btnIniciarSesion, 30);
        click(btnIniciarSesion);
    }

    public String getMensajeError() {
        waitElementIsVisibility(lblMensajeError, 15);
        return getText(lblMensajeError);
    }
}
