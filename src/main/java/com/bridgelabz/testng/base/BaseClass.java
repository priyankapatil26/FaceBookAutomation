package com.bridgelabz.testng.base;

import com.bridgelabz.testng.utility.UtilityClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
public class BaseClass {

        public static WebDriver driver;
        public static Properties properties;
        // public static EventFiringWebDriver eventFiringWebdriver;
        // public static WebEventListener eventListener;

        public BaseClass(){
            properties = new Properties();
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(
                        "src/main/java/com/bridgelabz/testng/config/config.properties");
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // for launching the browser
        public void initialization() {
            String browserName = properties.getProperty("browser");
            if (browserName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                // System.setProperty("webdriver.chrome.driver","/home/bridglabz/selenium webdriver/chromedriver_linux64/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
            } else if (browserName.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }

       /* eventFiringWebdriver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        eventFiringWebdriver.register(eventListener);
        driver = eventFiringWebdriver;*/

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(UtilityClass.PAGE_LOAD_TIME, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            driver.get(properties.getProperty("url"));

        }
    }

