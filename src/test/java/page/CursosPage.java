package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waits.WaitUtil.waitElementIsClickable;

public class CursosPage extends BasePage {

    public void seleccionarCurso(String cursoXPath) {
        WebElement element = findElementByXPathWithRetries(cursoXPath, 20);
        waitElementIsClickable(element, 30);
        click(element);
    }
}
