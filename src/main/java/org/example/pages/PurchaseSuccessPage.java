package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchaseSuccessPage {
    WebDriver driver;
    WebDriverWait wait;
    public PurchaseSuccessPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //locator
    private By successPurchaseBox = By.xpath("//h2[contains(text(), 'Thank you for your purchase!')]");

    //action
    public String readMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successPurchaseBox));
        return driver.findElement(successPurchaseBox).getText();
    }
}
