
package TestCases;

import Endpoints.Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;


public class Palindrome {

    private WebDriver driver;
    @BeforeTest
    public void setDriverSetUp() {
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
        this.driver.get(Util.baseUrl);
        System.out.println("The title of the webPage is:  " + driver.getTitle());
    }

    @Test(priority = 3)
   public void testData() {

        driver.findElement(By.id("originalWord")).sendKeys("mom");
        driver.findElement(By.xpath("/html/body/div/div/button")).click();
        WebElement element = driver.findElement(By.id("palindromeResult"));
        System.out.println("The result is :  " +element.getText());

    }

    @Test(dependsOnMethods = "testData")
    public void ValidateData(){

        String expectedTitle = Util.ExpectedName;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @AfterTest
    public void endSession(){
        driver.close();

    }
}
