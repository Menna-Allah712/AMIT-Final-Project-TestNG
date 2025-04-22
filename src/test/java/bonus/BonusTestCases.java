package bonus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BonusTestCases {
    @Test
    public void testSignupWithExistingUserName() throws InterruptedException {

    }

    @Test
    public void addSameProductToCart() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginLink();
        loginPage.insertUsername("Menna14");
        loginPage.insertPassword("123");
        LoginAlert loginAlert = loginPage.clickOnLoginButton();

        //compare
        String expectedResult = "Welcome";
        String actualResult = loginAlert.readMessage();
        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));

        loginAlert.closeAlert();

        LaptopsPage laptopsPage = homePage.clickLaptopsLink();
        ProductPage productPage = laptopsPage.clickOnFirstProduct();
        ProductAddedAlert productAddedAlert = productPage.clickOnAddToCartButton();
        //compare
        String expectedResult2 = "Product added";
        String actualResult2 = productAddedAlert.readMessage();
        //assert
        Assert.assertTrue(actualResult2.contains(expectedResult2));
        productAddedAlert.closeAlert();
        homePage = productPage.clickOnHomePageButton();

        laptopsPage = homePage.clickLaptopsLink();
        productPage = laptopsPage.clickOnFirstProduct();
        productAddedAlert = productPage.clickOnAddToCartButton();
        //compare
        String expectedResult3 = "Product added";
        String actualResult3 = productAddedAlert.readMessage();
        //assert
        Assert.assertTrue(actualResult3.contains(expectedResult3));
        productAddedAlert.closeAlert();

        CartPage cartPage = productPage.clickOnCartPageButton();
        Assert.assertNotNull(cartPage.getFirstItem());
        Assert.assertNotNull(cartPage.getSecondItem());

        //compare
        int firstCartItemPrice = cartPage.getFirstCartItemPrice();
        int secondCartItemPrice = cartPage.getSecondCartItemPrice();
        int totalPrice = cartPage.getTotalPrice();
        //assert
        Assert.assertEquals(firstCartItemPrice + secondCartItemPrice, totalPrice);

        PlaceOrderPage placeOrderPage = cartPage.clickOnPlaceOrderButton();

        //compare
        int totalOrderPrice = placeOrderPage.getTotalOrderPrice();

        //assert
        Assert.assertEquals(totalOrderPrice, totalPrice);

        placeOrderPage.insertName("Menna");
        placeOrderPage.insertCountry("Egypt");
        placeOrderPage.insertCity("Alexandria");
        placeOrderPage.insertCreditCard("1234567890123456");
        placeOrderPage.insertMonth("12");
        placeOrderPage.insertYear("26");

        PurchaseSuccessPage purchaseSuccessPage = placeOrderPage.clickOnPurchaseButton();

        //compare
        String expectedResult4 = "Thank you for your purchase!";
        String actualResult4 = purchaseSuccessPage.readMessage();

        //assert
        Assert.assertTrue(actualResult4.contains(expectedResult4));

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void loginWithInvalidCredentials() throws InterruptedException {

    }
}
