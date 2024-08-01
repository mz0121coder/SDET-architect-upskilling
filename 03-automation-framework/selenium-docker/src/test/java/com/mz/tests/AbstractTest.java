package com.mz.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AbstractTest {
    protected WebDriver driver;

    @BeforeTest
    public void setDriver() {
//        driver setup
        WebDriverManager.chromedriver().driverVersion("127.0.6533.88").setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
