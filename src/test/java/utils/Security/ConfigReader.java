package utils.Security;

import utils.Logger.LoggerUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("data.properties")) {
            if (input == null) {
                throw new NullPointerException("No se encontró el archivo data.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            LoggerUtil.logException("Se ha producido una excepción en la función ConfigReader", ex);
        }
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}
