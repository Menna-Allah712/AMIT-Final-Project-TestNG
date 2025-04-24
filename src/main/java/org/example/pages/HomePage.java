package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    //locators
    private By signupLink = By.linkText("Sign up");
    private By loginLink = By.linkText("Log in");
    private By welcomeLink = By.id("nameofuser");
    private By laptopsLink = By.linkText("Laptops");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Action
    public SignupPage clickSignupLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupLink));
        driver.findElement(signupLink).click();
        return new SignupPage(driver);
    }

    public LoginPage clickLoginLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public String readWelcomeMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeLink));
        return driver.findElement(welcomeLink).getText();
    }

    public LaptopsPage clickLaptopsLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(laptopsLink));
        driver.findElement(laptopsLink).click();
        return new LaptopsPage(driver);
    }
}
