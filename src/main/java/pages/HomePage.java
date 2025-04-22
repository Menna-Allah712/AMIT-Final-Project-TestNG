package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //locators
      private By SignupLink=By.linkText("Sign up");
      private By LoginLink =By.linkText("Log in");
      private By LaptopsLink =By.linkText("Laptops");
      private By LaptopsLink =By.linkText("Laptops");
    //Action
      public SignupPage clickSignupLink(){
          driver.findElement(SignupLink).click();
          return new SignupPage(driver);
      }
      public LoginPage clickLoginLink(){
          driver .findElement(LoginLink).click();
          return new LoginPage(driver);
      }
      public LaptopsPage clickLaptopsLink(){
          driver.findElement(LaptopsLink).click();
          return new LaptopsPage(driver);
      }
    public LaptopsPage clickLaptopsLink(){
        driver.findElement(LaptopsLink).click();
        return new LaptopsPage(driver);

}
