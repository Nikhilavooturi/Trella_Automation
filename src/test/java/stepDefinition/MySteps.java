package stepDefinition;

import classes.TrelloFunctions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.Test;

public class MySteps {

    @Test
    @Given("^I open the url and verify the \"(.*?)\" of the Page$")
    public void i_open_the_url_and_verify_the_of_the_Page(String title) throws Throwable {
        TrelloFunctions.openPage(title);
    }
    @Then("^I pass credentials and click on log in$")
    public void i_pass_credentials_and_click_on_log_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       TrelloFunctions.enterDetails();
    }

    @When("^I click on create button and click on create board$")
    public void i_click_on_create_button_and_click_on_create_board() throws Throwable {
        TrelloFunctions.createBoard();

    }


    @Then("^I drag and drop card from one board to other$")
    public void i_drag_and_drop_card_from_one_board_to_other() throws Throwable {
        TrelloFunctions.dragAndDrop();

    }

    @Then("^I calculate the coordinates of new element$")
    public void iCalculateTheCoordinatesOfNewElement() {
        TrelloFunctions.getcoordinates();
    }







    @Then("^I enter the board \"([^\"]*)\" and create card \"([^\"]*)\", \"([^\"]*)\"$")
    public void iEnterTheBoardAndCreateCard(String boardName, String cardName1, String cardName2) throws Throwable {
        TrelloFunctions.createList(boardName, cardName1, cardName2);
    }

    @Then("^I log out of the application$")
    public void iLogOutOfTheApplication() {
        TrelloFunctions.logOut();
    }


}

