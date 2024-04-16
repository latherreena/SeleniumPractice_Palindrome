
package TestCases;

import Endpoints.Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Palindrome {

    private WebDriver driver;

    @Test(priority = 1)
    public void setDriverSetUp() {
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
    }

    @Test(priority = 2)
    public void testFireFox()
    {
        this.driver.get(Util.baseUrl);
        System.out.println("The title of the webPage is:  " + driver.getTitle());
    }

    @Test(priority = 3)
   public void testData() {

        driver.findElement(By.id("originalWord")).sendKeys("mom");
        driver.findElement(By.xpath("/html/body/div/div/button")).click();
        WebElement element = driver.findElement(By.id("palindromeResult"));
        System.out.println("Palindrome Checker Result:  " +element.getText());
        driver.close();

    }



}
