package page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static hooks.Hooks.getDriver;
import static utils.Waits.WaitUtil.waitElementIsClickable;
import static utils.Waits.WaitUtil.waitElementIsVisibility;

public class HomePage extends BasePage {

    @FindBy(id = "dashboard")
    protected WebElement dashboard;

    @FindBy(className = "css-1ot2vyh-view")
    protected WebElement modalConsejosRapidos;

    @FindBy(xpath = "//*[@class='css-eezqiu-closeButton']/button")
    protected WebElement btnCerrarModalConsejosRapidos;

    @FindBy(xpath = "(//a[contains(@class, 'ic-app-header__menu-list-link')])[3]")
    protected WebElement menuCursos;

    public HomePage() {
        PageFactory.initElements(getDriver(), this); // Inicializa los elementos
    }

    public void waitDashboard() {
        waitElementIsVisibility(dashboard, 60);
    }

    public boolean existeModalConsejosRapidos() {
        try {
            waitElementIsVisibility(modalConsejosRapidos, 10);
            return true;
        }catch (TimeoutException timeoutException){
            return false;
        }
    }

    public void cerrarModalConsejosRapidos() {
        waitElementIsClickable(btnCerrarModalConsejosRapidos, 30);
        click(btnCerrarModalConsejosRapidos);
    }

    public void abrirMenuCursos() {
        waitElementIsClickable(menuCursos, 30);
        click(menuCursos);
    }
}
