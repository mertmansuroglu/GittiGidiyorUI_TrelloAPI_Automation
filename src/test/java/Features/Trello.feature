Feature: Trello Test Cases


  Scenario: Verify if the new board is successfully deleted after all required operations
    Given create new trello board called "board Mert"
    When get the list Id
    When I create two new cards on the board
    Then I verify that the cards have been added successfully
    When I update one of the card as adding a new description
    Then I should be able to delete the created cards
    Then I should be able to delete the created board

