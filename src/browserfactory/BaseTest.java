package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {

   public static WebDriver driver;//static Webdriver variable declared

    public void openBrowser(String baseUrl,String browser){
        //if condition to open different browser
        if(browser.equalsIgnoreCase("Chrome")){
            //it will open Chrome browser
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("FireFox")) {
            //it will open FireFox browser
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
            //it will open Edge browser
            driver = new EdgeDriver();

        }else {
            System.out.println("Wrong Browser Name");
        }
         //open Url
          driver.get(baseUrl);
          //maximise the window
          driver.manage().window().maximize();
          //we give implicit wait to driver
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       }

       public void closeBrowser(){
        //closing brower
        driver.close();
       }

}
