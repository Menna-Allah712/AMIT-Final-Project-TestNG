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
    //Action
      public SignupPage clickSignupLink(){
          driver.findElement(SignupLink).click();
          return new SignupPage(driver);


      }

}
