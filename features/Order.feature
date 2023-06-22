Feature: To verify drag and drop of trella boards

  Scenario Outline: Drag and drog list functionality
    Given I open the url and verify the "<title>" of the Page
    Then I pass credentials and click on log in
    When I click on create button and click on create board
    Then I enter the board "<boardTitle1>" and create card "<card1>", "<card2>"
    And I drag and drop card from one board to other
    Then I calculate the coordinates of new element
    Then I log out of the application

    Examples:
      | title            | boardTitle1 | card1 | card2 |
      | Log in to Trello | List A      | TO-DO | DOING |




