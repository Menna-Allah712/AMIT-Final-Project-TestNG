package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    private  By usernameBox=By.id("loginusername");
    private  By passwordBox=By.id("loginpassword");
    private By loginButton=By.cssSelector("button[onclick='logIn()']");

    //Actions
    public  void insertUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameBox));
        driver.findElement(usernameBox).sendKeys(username);
    }
    public  void insertPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox));
        driver.findElement(passwordBox).sendKeys(password);
    }
    public HomePage clickOnLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public LoginAlert clickOnLoginButtonWrongPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        return new LoginAlert(driver);
    }
}
