package com.bat.webdrivers.provider;

import com.bat.webdrivers.ChromeWebDriver;
import com.bat.webdrivers.EdgeWebDriver;
import com.bat.webdrivers.FirefoxWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebDriverProvider {
    @Autowired
    private ChromeWebDriver chromeWebDriver;

    @Autowired
    private FirefoxWebDriver firefoxWebDriver;

    @Autowired
    private EdgeWebDriver edgeWebDriver;

    public ChromeDriver getChromeWebDriver() throws Exception {
        return chromeWebDriver.getChromeDriver();
    }

    public FirefoxDriver getFirefoxWebDriver() throws Exception {
        return firefoxWebDriver.getFirefoxDriver();
    }

    public EdgeDriver getEdgeWebDriver() throws Exception {
        return edgeWebDriver.getEdgeDriver();
    }
}
