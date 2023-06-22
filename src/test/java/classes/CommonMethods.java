package classes;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static classes.OpenBrowser.driver;

public class CommonMethods {

public static void sleep(int milliSeconds){
    try{
        Thread.sleep(milliSeconds);
    }
    catch(InterruptedException ie){
    }
 }
public static void explicitWait(int seconds, String xpath){
    WebDriverWait wait = new WebDriverWait(driver,seconds);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
}
public static void scroll(String xpath){
    WebElement element = driver.findElement(By.xpath(xpath));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
}
public static void actionClick(WebElement element){
    Actions a = new Actions(driver);
    a.click(element).build().perform();
}
}
