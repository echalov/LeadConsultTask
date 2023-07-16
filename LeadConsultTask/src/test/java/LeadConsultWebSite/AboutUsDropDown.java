package LeadConsultWebSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class AboutUsDropDown {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.leadconsult.eu/contact-us/");
    }

    @Test
    public void ourCompanyWebSiteVerification() {
        WebElement dropDownAboutUs = driver.findElement(By.id("menu-item-5815"));
        dropDownAboutUs.click();

        WebElement ourCompany = driver.findElement(By.id("menu-item-7956"));
        ourCompany.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.leadconsult.eu/about-us/"));

    }

    @Test
    public void valuesWebSiteVerification() {
        WebElement dropDownAboutUs = driver.findElement(By.id("menu-item-5815"));
        dropDownAboutUs.click();

        WebElement coreValues = driver.findElement(By.id("menu-item-7957"));
        coreValues.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.leadconsult.eu/core-values-and-vision/"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
