package com.bat.webdrivers.provider;

import com.bat.webdrivers.ChromeWebDriver;
import com.bat.webdrivers.EdgeWebDriver;
import com.bat.webdrivers.FirefoxWebDriver;
import org.openqa.selenium.WebDriver;
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

    private ChromeDriver getChromeWebDriver() throws Exception {
        return chromeWebDriver.getChromeDriver();
    }

    private FirefoxDriver getFirefoxWebDriver() throws Exception {
        return firefoxWebDriver.getFirefoxDriver();
    }

    private EdgeDriver getEdgeWebDriver() throws Exception {
        return edgeWebDriver.getEdgeDriver();
    }

    public WebDriver getWebDriver(String browserName) throws Exception {
        if(browserName.toLowerCase().equals("chrome")) {
            return getChromeWebDriver();
        } else if(browserName.toLowerCase().equals("firefox")) {
            return getFirefoxWebDriver();
        } else if(browserName.toLowerCase().equals("edge")) {
            return getEdgeWebDriver();
        } else {
            throw new Exception("Invalid browser name provided");
        }
    }
}
