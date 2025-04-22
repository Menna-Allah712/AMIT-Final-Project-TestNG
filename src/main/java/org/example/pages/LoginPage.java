package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    private  By usernameBox=By.id("loginusername");
    private  By passwordBox=By.id("loginpassword");
    private By loginButton=By.cssSelector("button[onclick='register()']");

    //Actions
    public  void insertUsername(String username){
        driver.findElement(usernameBox).sendKeys(username);
    }
    public  void insertPassword(String password){
        driver.findElement(passwordBox).sendKeys(password);
    }
    public LoginAlert clickOnLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginAlert(driver);
    }

}
