package com.example.demo1;


// Generated by Selenium IDE

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchIMDB_remote_hub {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() throws MalformedURLException {
        open("about:blank");
        driver = getWebDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void imdbwandavision() {
        // Test name: imdb-wandavision
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://www.imdb.com/");
        // 2 | setWindowSize | 1421x691 |
        // 3 | click | name=q |
        driver.findElement(By.name("q")).click();
        // 4 | type | name=q | wandavision
        driver.findElement(By.name("q")).sendKeys("wandavision");
        // 5 | sendKeys | name=q | ${KEY_ENTER}
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        // 6 | click | linkText=WandaVision |
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated((By.linkText("WandaVision")))).click();

        // 7 | runScript | window.scrollTo(0,285) |
        js.executeScript("window.scrollTo(0,285)");
        // 8 | click | linkText=TRIVIA |
        driver.findElement(By.linkText("TRIVIA")).click();
    }
}
