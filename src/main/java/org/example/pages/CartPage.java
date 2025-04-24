package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //locators
    private By firstCartItem = By.xpath("//*[@id='tbodyid']/tr[1]");
    private By secondCartItem = By.xpath("//*[@id='tbodyid']/tr[2]");
    private By firstCartItemPrice = By.xpath("//*[@id='tbodyid']/tr[1]/td[3]");
    private By secondCartItemPrice = By.xpath("//*[@id='tbodyid']/tr[2]/td[3]");
    private By totalPrice = By.id("totalp");
    private By placeOrderButton = By.cssSelector(".btn.btn-success");

    //actions
    public WebElement getFirstItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstCartItem));
        return driver.findElement(firstCartItem);
    }

    public WebElement getSecondItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondCartItem));
        return driver.findElement(secondCartItem);
    }

    public int getFirstCartItemPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstCartItemPrice));
        return Integer.parseInt(driver.findElement(firstCartItemPrice).getText());
    }
    public int getSecondCartItemPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondCartItemPrice));
        return Integer.parseInt(driver.findElement(secondCartItemPrice).getText());
    }

    public int getTotalPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        return Integer.parseInt(driver.findElement(totalPrice).getText());
    }

    public PlaceOrderPage clickOnPlaceOrderButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton));
        driver.findElement(placeOrderButton).click();
        return new PlaceOrderPage(driver);
    }
}
