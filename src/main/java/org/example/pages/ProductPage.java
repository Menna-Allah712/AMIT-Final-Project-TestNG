package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    private By addtocartbutton = By.cssSelector(".btn.btn-success.btn-lg");
    private By homePageButton = By.xpath("(//a[contains(@href, 'index.html')])[1]");
    private By cartPageButton = By.linkText("Cart");

    //Actions
    public ProductAddedAlert clickOnAddToCartButton() {
        driver.findElement(addtocartbutton).click();
        return new ProductAddedAlert(driver);
    }

    public HomePage clickOnHomePageButton() {
        driver.findElement(homePageButton).click();
        return new HomePage(driver);
    }

    public CartPage clickOnCartPageButton() {
        driver.findElement(cartPageButton).click();
        return new CartPage(driver);
    }

}
