package com.example.demo1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;


public class RobobarTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        /*
        Configuration.startMaximized = true;
        open("about:blank");
        driver = getWebDriver();
        */
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    /*
    @Test
    public void inicial() {
        driver.get("http://localhost:3000/#!/");

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated((By.className("ng-binding")))).getText().equals("€0.00");
    }
    @Test
    public void RoboCola() {
        driver.get("http://localhost:3000/#!/");

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[2]/button")))).click();
        driver.findElement(By.className("ng-binding")).getText().equals("€1.25");
    }

    @Test
    public void RoboBeer() {
        driver.get("http://localhost:3000/#!/");

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[2]/button")))).click();
        driver.findElement((By.xpath("//tr[2]/td[3]/div/div/div[2]/button"))).click();
        driver.findElement(By.className("ng-binding")).getText().equals("€3.25");

    }
    @Test
    public void RoboWine() {
        driver.get("http://localhost:3000/#!/");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[2]/button")))).click();
        driver.findElement((By.xpath("//tr[2]/td[3]/div/div/div[2]/button"))).click();
        driver.findElement((By.xpath("//tr[3]/td[3]/div/div/div[2]/button"))).click();
        driver.findElement(By.className("ng-binding")).getText().equals("€6.25");

    }
    @Test
    public void Submit() {
        driver.get("http://localhost:3000/#!/");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//tr[3]/td[3]/div/div/div[2]/button")))).click();
        driver.findElement(By.xpath("//div[3]/div/button")).click();

        new WebDriverWait(driver, 10)
               .until(ExpectedConditions.presenceOfElementLocated((By.id("ageInput")))).click();
        driver.findElement(By.id("ageInput")).sendKeys("21");

        driver.findElement((By.xpath("//button[@type='submit']"))).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//p[contains(.,'Coming right up! ~bzzzt~')]"))));
    }*/
    @Test
    public void Robobar() {
        driver.get("http://localhost:3000/#!/");

        //Check values
        new WebDriverWait(driver, 10)
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
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated((By.id("ageInput")))).click();
        driver.findElement(By.id("ageInput")).sendKeys("21");

        //Click order
        driver.findElement((By.xpath("//button[@type='submit']"))).click();

        //Check success
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated((By.xpath("//p[contains(.,'Coming right up! ~bzzzt~')]"))));
    }



}