package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    //initialise base url link
    String baseUrl ="http://the-internet.herokuapp.com/login";
     public String browser="Chrome"; // Option to choose Chrome browser please remove comment"//"
    //public String browser="FireFox";// Option to choose FireFox browser please remove comment"//"
   // public String browser="Edge";// Option to choose Edge browser "
    @Before
    //loaunching different browser
    public void setUp(){openBrowser(baseUrl,browser); }
    @Test
    //1. userSholdLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //Verify the text “Secure Area”
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Secure Area')] "));
        String acctualMessage = element.getText();
        System.out.println(acctualMessage);
        String expectedMessage ="Secure Area";
        Assert.assertEquals("Not Match",expectedMessage,acctualMessage);


    }
    @Test
    //2. verifyTheUsernameErrorMessage
    public void verifyTheUsernameErrorMessage(){
         //Enter “tomsmith1” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //Verify the error message “Your username is invalid!”
        String acctualErrorUsername = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        boolean actMessage = acctualErrorUsername.contains("Your username is invalid!");
        Assert.assertTrue(actMessage);
    }
    @Test
    //3. verifyThePasswordErrorMessage
    public void verifyThePasswordErrorMessage(){
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //Verify the error message “Your password is invalid!”
        WebElement message = driver.findElement(By.xpath("//div[@id='flash']"));
        String acctualErrorPassword = message.getText();
        System.out.println(acctualErrorPassword);
        boolean actMessage = acctualErrorPassword.contains("Your password is invalid!");
        Assert.assertTrue(actMessage);
    }
    //cloing browser
    @After
    public void tearDown(){closeBrowser();}
}
