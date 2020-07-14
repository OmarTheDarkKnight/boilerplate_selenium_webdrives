package com.bat.webdrivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChromeWebDriver extends BaseWebDriver {
    @Value("${chrome.driver-path}")
    private String driverPath;

    @Value("${chrome.binary-path}")
    private String binaryPath;

    @Value("${chrome.disable-notifications}")
    private boolean disableNotification;
    @Value("${chrome.disable-infobar}")
    private boolean disableInforbar;
    @Value("${chrome.start-maximized}")
    private boolean startMaximized;
    @Value("${chrome.ignore-bad-ssl}")
    private boolean ignoreBadSSL;

    @Value("${chrome.disable-proxy}")
    private boolean disableProxy;
    @Value("${chrome.proxy-server}")
    private String proxyAddress;

    @Value("${chrome.profile}")
    private String profilePath;

    @Value("${chrome.log}")
    private String logPath;
    @Value("${chrome.silent-log}")
    private boolean silentLog;

    public ChromeWebDriver() {}

    public ChromeDriver getChromeDriver() {
        ChromeOptions ops = new ChromeOptions();

        try{
            if(!isEmpty(binaryPath)) {
                ops.setBinary(binaryPath);
            }

            if(disableNotification) {
                ops.addArguments("--disable-notifications");
            }

            if(disableInforbar) {
                ops.addArguments("disable-infobars");
            }

            if(startMaximized) {
                ops.addArguments("--start-maximized");
            }

            if(!disableProxy && !isEmpty(proxyAddress)) {
                ops.addArguments("--proxy-server=" + proxyAddress);
            }

            if(!isEmpty(profilePath)) {
                ops.addArguments("user-data-dir=" + profilePath);// Don't give default folder
            }

            // ops.setPageLoadStrategy(PageLoadStrategy.EAGER);

            if(!isEmpty(logPath)) {
                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, logPath);
            }

            if(silentLog) {
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, Boolean.toString(silentLog));
            }

        } catch (Exception exception) {
            System.out.println("FAILED TO INITIATE CHROME DRIVER");
            System.out.println("Please check the properties file and ensure the values are given properly");
            System.out.println(exception.getMessage());
        }

        System.setProperty("webdriver.chrome.driver", driverPath);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, driverPath);
        return new ChromeDriver(ops);
    }

    @Override
    public String toString() {
        return "ChromeWebDriver{" +
                "binaryPath='" + binaryPath + '\'' +
                ", disableNotification=" + disableNotification +
                ", disableInforbar=" + disableInforbar +
                ", startMaximized=" + startMaximized +
                ", ignoreBadSSL=" + ignoreBadSSL +
                ", disableProxy=" + disableProxy +
                ", proxyAddress='" + proxyAddress + '\'' +
                ", profilePath='" + profilePath + '\'' +
                ", logPath='" + logPath + '\'' +
                ", silentLog=" + silentLog +
                '}';
    }
}
