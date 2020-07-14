# boilerplate_selenium_webdrives
Boiler plate code to use the basic browser web drivers in selenium

Configurations for the browsers are read from properties file. It is located inside 
> **src/main/resources/browser_config,properties**

Download the required browser drivers from https://www.selenium.dev/downloads under the **Browsers** section.

Select your browser and download the driver as per your browser version and operating system.

Extract the download file and copy the driver file in your hard drive.

Add the location in the **browser_config.properties** file under respective browser's driver-path property. Like for chrome in windows,
>**chrome.driver-path = C:\\\Drivers\\chromedriver.exe**