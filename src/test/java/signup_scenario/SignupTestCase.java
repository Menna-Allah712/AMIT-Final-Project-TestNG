package signup_scenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SignupTestCase {
    @Test
    public void testSuccessSignup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/");
        driver.findElement(By.id("signin2")).click();
        driver.findElement(By.id("sign-username")).sendKeys("Menna7");
        driver.findElement(By.id("sign-password")).sendKeys("123!");
        driver.findElement(By.className("btn btn-primary")).click();

        //compare
        Thread.sleep(1000);
        String excpectedResult="Sign up successful.";
        String actualResult=driver.findElement(By.id("flash")).getText();
        //Assertion
        Assert.assertTrue(actualResult.contains(excpectedResult));
        Thread.sleep(2000);
        driver.quit();


    }
}
