package signup_scenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.example.pages.HomePage;
import org.example.pages.SignupAlert;
import org.example.pages.SignupPage;

public class SignupTestCase {
    @Test
    public void testSuccessSignup() throws InterruptedException {
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
        String expectedResult = "Sign up successful.";
        String actualResult = signupAlert.readMessage();
        //assert
        Assert.assertTrue(actualResult.contains(expectedResult));

        signupAlert.closeAlert();

        Thread.sleep(2000);
        driver.quit();
    }


}
