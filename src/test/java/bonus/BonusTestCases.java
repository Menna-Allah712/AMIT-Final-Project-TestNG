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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/");

        HomePage homePage = new HomePage(driver);
        SignupPage signupPage = homePage.clickSignupLink();
        signupPage.insertUsername("Menna14");
        signupPage.insertPassword("123");
        SignupAlert signupAlert = signupPage.clickOnSignupButton();

        //compare
        String expectedResult = "This user already exist.";
        String actualResult = signupAlert.readMessage();
        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));

        signupAlert.closeAlert();

        Thread.sleep(2000);
        driver.quit();
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
        homePage = loginPage.clickOnLoginButton();

        //compare
        String expectedResult = "Welcome";
        String actualResult = homePage.readWelcomeMessage();
        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));

        LaptopsPage laptopsPage = homePage.clickLaptopsLink();
        Thread.sleep(1000);
        ProductPage productPage = laptopsPage.clickOnFirstProduct();
        ProductAddedAlert productAddedAlert = productPage.clickOnAddToCartButton();
        //compare
        String expectedResult2 = "Product added";
        String actualResult2 = productAddedAlert.readMessage();
        //assert
        Assert.assertTrue(actualResult2.contains(expectedResult2));
        productPage = productAddedAlert.closeAlert();

        productAddedAlert = productPage.clickOnAddToCartButton();
        //compare
        String expectedResult3 = "Product added";
        String actualResult3 = productAddedAlert.readMessage();
        //assert
        Assert.assertTrue(actualResult3.contains(expectedResult3));
        productPage = productAddedAlert.closeAlert();

        CartPage cartPage = productPage.clickOnCartPageButton();
        Assert.assertNotNull(cartPage.getFirstItem());
        Assert.assertNotNull(cartPage.getSecondItem());


        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void loginWithInvalidCredentials() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginLink();
        loginPage.insertUsername("Menna14");
        loginPage.insertPassword("12345");
        LoginAlert loginAlert = loginPage.clickOnLoginButtonWrongPassword();

        //compare
        String expectedResult = "Wrong password.";
        String actualResult = loginAlert.readMessage();
        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));

        loginAlert.closeAlert();

        Thread.sleep(2000);
        driver.quit();
    }
}
