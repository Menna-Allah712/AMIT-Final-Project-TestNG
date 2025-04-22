package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaptopsPage {
        WebDriver driver;
        WebDriverWait wait;
    public LaptopsPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        //Locator
          private By firstProduct = By.xpath("(//a[contains(@href, 'prod.html')])[1]");
          private By secondProduct = By.xpath("(//a[contains(@href, 'prod.html')])[3]");
        //Actions
         public ProductPage clickOnFirstProduct(){
             driver.findElement(firstProduct).click();
             return new ProductPage(driver);
    }
        public ProductPage clickOnSecondProduct(){
              driver.findElement(secondProduct).click();
              return new ProductPage(driver);
    }

}
