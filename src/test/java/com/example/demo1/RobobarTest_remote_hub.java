package com.example.demo1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RobobarTest_remote_hub {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("browserName","firefox");
        capabilities.setCapability("browserName", Configuration.browser);
        driver = new RemoteWebDriver(new URL("http://10.250.9.2:4444"), capabilities);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Robobar() {
        driver.get("http://10.250.9.2:3000/#!/");

        //Check values
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated((By.className("ng-binding"))));

        String v = driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText();
        assertEquals(v, "€0.00");

        driver.findElement((By.xpath("//div[2]/button"))).click();
        v = driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText();
        assertEquals(v, "€1.25");

        driver.findElement((By.xpath("//tr[2]/td[3]/div/div/div[2]/button"))).click();
        v = driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText();
        assertEquals(v, "€3.25");

        driver.findElement((By.xpath("//tr[3]/td[3]/div/div/div[2]/button"))).click();
        v = driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText();
        assertEquals(v, "€6.25");

        //Submit
        driver.findElement(By.xpath("//div[3]/div/button")).click();

        //Check age
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated((By.id("ageInput")))).click();
        driver.findElement(By.id("ageInput")).sendKeys("21");

        //Click order
        driver.findElement((By.xpath("//button[@type='submit']"))).click();

        //Check success
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//p[contains(.,'Coming right up! ~bzzzt~')]"))));
    }



}