import com.bat.configurations.SpringConfig;
import com.bat.webdrivers.provider.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
    }
}
