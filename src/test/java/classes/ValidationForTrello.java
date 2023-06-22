package classes;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

import static classes.OpenBrowser.driver;
import static classes.TrelloFunctions.UserName_Xpath;

public class ValidationForTrello {
    public static void validateTitle(String expectedTitle){
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        //actualTitle=actualTitle.substring(0,21);
        if(expectedTitle.equalsIgnoreCase(actualTitle)){
            Reporter.log("Title is successfully validated");
        }
        else{
             Assert.fail("Invalid Title - Not matched");
        }
}


}