package com.bat.webdrivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChromeWebDriver extends BaseWebDriver {
    @Value("${chrome.driver-path}")
    private String driverPath;

    @Value("${chrome.binary-path}")
    private String binaryPath;

    @Value("${chrome.enable-notifications}")
    private boolean enableNotifications;
    @Value("${chrome.enable-info-bar}")
    private boolean enableInfoBar;
    @Value("${chrome.start-maximized}")
    private boolean startMaximized;
    @Value("${chrome.accept-bad-ssl}")
    private boolean acceptBadSSL;
    @Value("${chrome.enable-extensions}")
    private boolean enableExtension;

    @Value("${chrome.use-proxy}")
    private boolean useProxy;
    @Value("${chrome.proxy-server}")
    private String proxyAddress;

    @Value("${chrome.profile}")
    private String profilePath;

    @Value("${chrome.log}")
    private String logPath;
    @Value("${chrome.silent-log}")
    private boolean silentLog;

    private List<String> excludeSwitches = new ArrayList<String>();

    public ChromeWebDriver() {}

    @Override
    public ChromeDriver getChromeDriver() throws Exception {
        ChromeOptions options = new ChromeOptions();

        try{
            if(!isEmpty(binaryPath)) {
                options.setBinary(binaryPath);
            }

            if(!enableNotifications) {
                options.addArguments("--disable-notifications");
            }

            if(!enableInfoBar) {
                excludeSwitches.add("enable-automation");
//                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            }

            if(startMaximized) {
                options.addArguments("--start-maximized");
            }

            if(acceptBadSSL) {
                options.addArguments("ignore-certificate-errors");
            }

            if(!enableExtension) {
                excludeSwitches.add("load-extension");
//                options.setExperimentalOption("excludeSwitches", new String[]{"load-extension"});
            }

            if(useProxy && !isEmpty(proxyAddress)) {
                options.addArguments("--proxy-server=" + proxyAddress);
            }

            if(!isEmpty(profilePath)) {
                options.addArguments("user-data-dir=" + profilePath);// Don't give default folder
            }

            // options.setPageLoadStrategy(PageLoadStrategy.EAGER);

            if(!isEmpty(logPath)) {
                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, logPath);
            }

            if(silentLog) {
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, Boolean.toString(silentLog));
            }

            if(!excludeSwitches.isEmpty()) {
                options.setExperimentalOption("excludeSwitches", excludeSwitches.toArray());
            }

        } catch (Exception exception) {
            System.out.println("FAILED TO INITIATE CHROME DRIVER");
            throw new Exception("CHROME DRIVER EXCEPTION : " + exception.getMessage());
        }

        System.setProperty("webdriver.chrome.driver", driverPath);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, driverPath);
        return new ChromeDriver(options);
    }
}
