/*
Napisati dva smoke testa za https://www.telerik.com/support/demos:
Proveriti da klikom na Desktop odlazimo na tu sekciju
Proveriti da klikom na Mobile odlazimo na tu sekciju
Koristiti TestNG, asserte.
 */

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class Zadatak {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://www.telerik.com/support/demos");
    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }

    @Test
    public void testPickDesktop(){
        WebElement pickDesktop = driver.findElement(By.xpath
                ("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        pickDesktop.click();
        String actualTitle = pickDesktop.getText();
        String expectedTitle = "Desktop";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testPickMobile(){
        WebElement pickMobile = driver.findElement(By.xpath
                ("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        pickMobile.click();
        String actualTitle = pickMobile.getText();
        String expectedTitle = "Mobile";

        Assert.assertEquals(actualTitle, expectedTitle);

    }


}
