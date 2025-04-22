package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    WebDriver driver;
    WebDriverWait wait;
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //locators
    private By usernameBox = By.id("sign-username");
    private By passwordBox = By.id("sign-password");
    private By signupButton = By.cssSelector("button[onclick='register()']");


    public void insertUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameBox));
        driver.findElement(usernameBox).sendKeys(username);
    }

    public void insertPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox));
        driver.findElement(passwordBox).sendKeys(password);
    }

    public SignupAlert clickOnSignupButton() {
        driver.findElement(signupButton).click();
        return new SignupAlert(driver);
    }
}
