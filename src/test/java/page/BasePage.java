package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.Logger.LoggerUtil;

import static hooks.Hooks.getDriver;
import static utils.Waits.WaitUtil.waitForSeconds;

public class BasePage {

    public void getUrl(String url) {
        try {
            getDriver().get(url);
        } catch (Exception e) {
            LoggerUtil.logException("Error inesperado en la función getUrl: ", e);
        }
    }

    public void sendText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        element.click();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public WebElement findElementByXPathWithRetries(String xpath, int retriesMax) {
        int retries = 0;
        do {
            retries++;
            try {
                return getDriver().findElement(By.xpath(xpath));
            } catch (NoSuchElementException e) {
                if (retries == retriesMax) {
                    throw new NoSuchElementException("No se pudo encontrar el WebElement con el xpath: " + xpath + " luego de " + retriesMax + " intentos.");
                }
                waitForSeconds(1); // Espera 1 segundo antes de reintentar
            }
        } while (retries < retriesMax);

        // Lanzar una excepción como último recurso, aunque teóricamente nunca debería alcanzarse.
        throw new NoSuchElementException("Error inesperado: no se encontró el elemento después de todos los reintentos.");
    }

}
