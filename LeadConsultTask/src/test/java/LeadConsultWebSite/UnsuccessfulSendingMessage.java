package LeadConsultWebSite;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.*;

import java.time.Duration;

public class UnsuccessfulSendingMessage {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //driver.manage().window().maximize(); if the browser is in full screen after entering a text in the message field,
        // "I am not a robot" selection is visualized and the send button is hidden and I can't send a message, respectively I can't verify that a message can't be sent without
        //this verification.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.leadconsult.eu/contact-us/");
    }

    @Test
    public void sendingMessage() {

        WebElement yourNameField = driver.findElement(By.name("your-name"));
        yourNameField.sendKeys("Evgeni Chalov");

        WebElement yourEmailField = driver.findElement(By.name("your-email"));
        yourEmailField.sendKeys("evgenichalov@gmail.com");

        WebElement yourPhoneNumberField = driver.findElement(By.name("tel-760"));
        yourPhoneNumberField.sendKeys("0888777777");

        WebElement yourMessageFiled = driver.findElement(By.name("your-message"));
        yourMessageFiled.sendKeys("Hi!");

        WebElement sendButton = driver.findElement(By.cssSelector("#wpcf7-f5661-p6126-o1 > form > p:nth-child(9) > input"));
        sendButton.click();

        WebElement verificationMessage = driver.findElement(By.xpath("//*[@id=\"wpcf7-f5661-p6126-o1\"]/form/span/span[2]"));
        String value = verificationMessage.getText();
        Assert.assertEquals(value, "Please verify that you are not a robot.");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
