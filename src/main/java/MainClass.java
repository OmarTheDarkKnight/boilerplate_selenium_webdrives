import com.bat.configurations.SpringConfig;
import com.bat.webdrivers.provider.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        WebDriverProvider webDriverProvider = applicationContext.getBean("webDriverProvider", WebDriverProvider.class);

        // for chrome
        try {
            WebDriver chromeDriver = webDriverProvider.getChromeWebDriver();
            chromeDriver.get("http://github.com");
        } catch (Exception exception) {
            System.out.println("FAILED TO INITIATE CHROME");
            System.out.println(exception.getMessage());
        }

        // for firefox
        try {
            WebDriver firefoxDriver = webDriverProvider.getFirefoxWebDriver();
            firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            firefoxDriver.get("http://google.com");
        } catch (Exception exception) {
            System.out.println("FAILED TO INITIATE FIREFOX");
            System.out.println(exception.getMessage());
        }

        // for edge
        try {
            WebDriver edgeDriver = webDriverProvider.getEdgeWebDriver();
            edgeDriver.get("http://yahoo.com");
        } catch (Exception exception) {
            System.out.println("FAILED TO INITIATE EDGE");
            System.out.println(exception.getMessage());
        }
    }
}
