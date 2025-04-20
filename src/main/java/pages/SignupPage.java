package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    WebDriver driver;
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    //locators
    private By usernameBox = By.id("sign-username");
    private By passwordBox = By.id("sign-password");
    private By signupButton = By.cssSelector("button[onclick='register()']");

    
}
