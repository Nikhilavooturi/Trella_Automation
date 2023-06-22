package classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static classes.OpenBrowser.driver;

public class TrelloFunctions {

    private static final String fileName = "./resources/Data.properties";
    public static final String UserName_Xpath="//*[@id=\"user\"]";
    public static final String ContinueButton_Xpath="//*[@id=\"login\"]";
    public static final String Password_Xpath="//input[@name='password']";
    public static final String LoginButton_Xpath = "(//span[contains(text(), 'Log in')])[1]";
    public static final String CreateButton_Xpath = "//*[@class=\"X7iA6JJNiXCA2r\"]";
    public static final String CreateBoard_Xpath="(//*[@class='kgXqyT2weJmrQm'])[1]";
    public static final String BoardTitle_Xpath="//input[@class='nch-textfield__input lsOhPsHuxEMYEb lsOhPsHuxEMYEb VkPAAkbpkKnPst']";
    public static final String CreateBoardSubmit_Xpath="//button[@data-testid='create-board-submit-button']";

    public static final String AddAList_Xpath = "//*[@class=\"js-add-list list-wrapper mod-add is-idle\"]";
    public static final String AddListName_Xpath="//*[@class=\"list-name-input\"]";
    public static final String AddListButton_Xpath = "//*[@class=\"nch-button nch-button--primary mod-list-add-button js-save-edit\"]";
    public static final String ToDoBoard_Xpath="//*[@class='list-card-title js-card-name']";
    public static final String DoingBoard_Xpath="(//*[@class=\"js-add-a-card\"])[2]";
    public static final String MovedCard_Xpath = "//span[@class='list-card-title js-card-name'][@dir='auto']";
    public static final String ProfileButton_Xpath="//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']";
    public static final String LogoutButton_Xpath="//button[@data-testid='account-menu-logout']";
    public static final String AddACard_Xpath = "(//*[@class='open-card-composer js-open-card-composer'])[1]";

    public static final String AddCardButton_Xpath = "//*[@class='nch-button nch-button--primary confirm mod-compact js-add-card']";
    public static final String AddACardContent_Xpath = "(//*[@class='list-card-composer-textarea js-card-title'])[1]";



    public static void openPage(String title) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        Properties prop = new Properties();
        prop.load(fis);
        OpenBrowser.openSelectedBrowser(BrowserTypes.CHROME);
        driver.get(prop.getProperty("baseUrl"));
        driver.manage().window().maximize();
        ValidationForTrello.validateTitle(title);

    }



    public static void enterDetails() throws IOException {
        SignUp s = new SignUp();
        FileInputStream fis = new FileInputStream(fileName);
        Properties prop = new Properties();
        prop.load(fis);
        s.setUserName(prop.getProperty("userId"));
        s.setPassword(prop.getProperty("password"));
        CommonMethods.sleep(2000);
        driver.findElement(TrelloPageLocators(UserName_Xpath)).sendKeys(s.getUserName());
        CommonMethods.sleep(2000);

        driver.findElement(TrelloPageLocators(ContinueButton_Xpath)).click();
        CommonMethods.sleep(2000);
        driver.findElement(TrelloPageLocators(Password_Xpath)).sendKeys(s.getPassword());
        driver.findElement(TrelloPageLocators(LoginButton_Xpath)).click();
    }

    public static void createBoard( ){
      CommonMethods.sleep(3000);
      driver.findElement(TrelloPageLocators(CreateButton_Xpath)).click();
        CommonMethods.sleep(5000);
      driver.findElement(TrelloPageLocators(CreateBoard_Xpath)).click();

    }
    public static void createList(String boardName, String cardName1, String cardName2) {
        driver.findElement(TrelloPageLocators(BoardTitle_Xpath)).sendKeys(boardName);
        driver.findElement(TrelloPageLocators(CreateBoardSubmit_Xpath)).isEnabled();
        CommonMethods.sleep(5000);
        driver.findElement(TrelloPageLocators(CreateBoardSubmit_Xpath)).click();
        System.out.println("Board is created*********");
        CommonMethods.sleep(5000);
        //driver.findElement(TrelloPageLocators(AddAList_Xpath)).click();
        driver.findElement(TrelloPageLocators(AddListName_Xpath)).sendKeys(cardName1);
        driver.findElement(TrelloPageLocators(AddListButton_Xpath)).click();
        CommonMethods.sleep(5000);


        driver.findElement(TrelloPageLocators(AddListName_Xpath)).sendKeys(cardName2);
        driver.findElement(TrelloPageLocators(AddListButton_Xpath)).click();
        CommonMethods.sleep(5000);
        driver.findElement(TrelloPageLocators(AddACard_Xpath)).click();
        CommonMethods.sleep(5000);
        driver.findElement(TrelloPageLocators(AddACardContent_Xpath)).sendKeys("Regression");
        driver.findElement(TrelloPageLocators(AddCardButton_Xpath)).click();


    }
    public static void dragAndDrop() {
        Actions a = new Actions(driver);
        WebElement e1 = driver.findElement(TrelloPageLocators(ToDoBoard_Xpath));
        WebElement e2 = driver.findElement(TrelloPageLocators(DoingBoard_Xpath));
        a.dragAndDrop(e1, e2).build().perform();
    }
    public static void getcoordinates(){
        WebElement ddele = driver.findElement(TrelloPageLocators(MovedCard_Xpath));
        int getX = ddele.getLocation().getX();
        System.out.println("X coordinate: " +getX);
        int getY = ddele.getLocation().getY();
        System.out.println("X coordinate: " +getY);
    }
    public static void logOut() {
        driver.findElement(By.xpath(ProfileButton_Xpath)).click();
        driver.findElement(By.xpath(LogoutButton_Xpath)).click();
        driver.quit();
    }

    public static By TrelloPageLocators(String locators) {
        return By.xpath(locators);
    }



}
