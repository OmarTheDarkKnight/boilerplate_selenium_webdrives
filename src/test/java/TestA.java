import configurations.SpringConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import webdrivers.provider.WebDriverProvider;

public class TestA {

    @Test
    public void tester() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        WebDriverProvider webDriverProvider = applicationContext.getBean("webDriverProvider", WebDriverProvider.class);
        try{
            WebDriver driver = webDriverProvider.getWebDriver("Firefox");
            driver.get("http://google.com");
        } catch (Exception exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
