package classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class OpenBrowser {
    public static WebDriver driver;
    public static void openSelectedBrowser(BrowserTypes browser){
       switch(browser)
        {
           case CHROME:
           {
               System.setProperty("webdriver.chrome.driver","./resources/drivers/chromedriver.exe");
               driver = new ChromeDriver();
               break;
           }
            case FIREFOX:
            {
                driver = new FirefoxDriver();
                break;
            }
            default:
            {
                break;
            }

        }
    }
}
