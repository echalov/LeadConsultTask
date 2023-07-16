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

public class OurPartnersDropDown {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.leadconsult.eu/contact-us/");
    }

    @Test
    public void businessPartnersWebSiteVerification() {
        WebElement dropDownOurPartners= driver.findElement(By.id("menu-item-8088"));
        dropDownOurPartners.click();

        WebElement businessPartners = driver.findElement(By.id("menu-item-8087"));
        businessPartners.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.leadconsult.eu/business-partners/"));

    }

    @Test
    public void technicalPartnersWebSiteVerification() {
        WebElement dropDownOurPartners = driver.findElement(By.id("menu-item-8088"));
        dropDownOurPartners.click();

        WebElement technicalPartners = driver.findElement(By.id("menu-item-8083"));
        technicalPartners.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.leadconsult.eu/technical-partners/"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
