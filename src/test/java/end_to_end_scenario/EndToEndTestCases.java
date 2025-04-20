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
            driver.findElement(By.id("login2")).click();
            driver.findElement(By.id("loginusername")).sendKeys("Menna7");
            driver.findElement(By.id("loginpassword")).sendKeys("123!");
            driver.findElement(By.className("btn btn-primary")).click();

            //compare
            Thread.sleep(2000);
            String excpectedResult="Welcome Menna7";
            String actualResult=driver.findElement(By.id("nameofuser")).getText();
            //Assertion
            Assert.assertTrue(actualResult.contains(excpectedResult));

        }
        public void addProductToCartSuccessfully()



    }
}
