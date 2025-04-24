package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceOrderPage {
    WebDriver driver;
    WebDriverWait wait;
    //locators
    private By totalPrice = By.id("totalm");
    private By nameBox = By.id("name");
    private By countryBox = By.id("country");
    private By cityBox = By.id("city");
    private By creditCartBox = By.id("card");
    private By monthBox = By.id("month");
    private By yearBox = By.id("year");
    private By purchaseButton = By.cssSelector("button[onclick='purchaseOrder()']");

    public PlaceOrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //actions
    public int getTotalOrderPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        String total = driver.findElement(totalPrice).getText();
        String numeric = total.split(":")[1].trim();
        int value = Integer.parseInt(numeric);
        return value;
    }

    public void insertName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameBox));
        driver.findElement(nameBox).sendKeys(name);
    }

    public void insertCountry(String country) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryBox));
        driver.findElement(countryBox).sendKeys(country);
    }

    public void insertCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityBox));
        driver.findElement(cityBox).sendKeys(city);
    }

    public void insertCreditCard(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(creditCartBox));
        driver.findElement(creditCartBox).sendKeys(number);
    }

    public void insertMonth(String month) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(monthBox));
        driver.findElement(monthBox).sendKeys(month);
    }

    public void insertYear(String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(yearBox));
        driver.findElement(yearBox).sendKeys(year);
    }

    public PurchaseSuccessPage clickOnPurchaseButton() {
        driver.findElement(purchaseButton).click();
        return new PurchaseSuccessPage(driver);
    }
}
