package end_to_end_scenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

@RunWith(Enclosed.class)
public class EndToEndTestCases {
    public static class LoginTestCase {
        @Test
        public void logInSuccessfully() throws InterruptedException {
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
            Assert.assertTrue(actualResult.contains(expectedResult));
            productAddedAlert.closeAlert();
            productPage.clickOnHomePageButton();

            LaptopsPage laptopsPage = homePage.clickLaptopsLink();
            ProductPage productPage = laptopsPage.clickOnSecondProduct();
            ProductAddedAlert productAddedAlert = productPage.clickOnAddToCartButton();
            //compare
            String expectedResult3 = "Product added";
            String actualResult3 = productAddedAlert.readMessage();
            //assert
            Assert.assertTrue(actualResult.contains(expectedResult));
            productAddedAlert.closeAlert();



            Thread.sleep(2000);
            driver.quit();
        }


    }
}
