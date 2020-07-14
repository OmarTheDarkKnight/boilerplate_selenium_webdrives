import com.bat.configurations.SpringConfig;
import com.bat.webdrivers.provider.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        WebDriverProvider webDriverProvider = applicationContext.getBean("webDriverProvider", WebDriverProvider.class);
        WebDriver webDriver = webDriverProvider.getChromeWebDriver();
        webDriver.get("http://github.com");
    }
}
