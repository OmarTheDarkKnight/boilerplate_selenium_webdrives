package com.bat.webdrivers.provider;

import com.bat.webdrivers.ChromeWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebDriverProvider {
    @Autowired
    private ChromeWebDriver chromeWebDriver;

    public ChromeDriver getChromeWebDriver() {
        return chromeWebDriver.getChromeDriver();
    }
}
