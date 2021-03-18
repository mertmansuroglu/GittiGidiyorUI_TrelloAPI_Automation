Feature: GittiGidiyor Test Cases


  Scenario Outline: I should be able navigate to insider page
    Given I open the browser "<browser>"
    Given I delete the cookies
    When I  visit GittiGidiyor web page
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/"
    Then I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
#      | firefox |

  Scenario Outline: I should be able open login page
    Given I open the browser "<browser>"
    When I  visit GittiGidiyor web page
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/"
    When I click login button
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/uye-girisi"
    Then I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
#      | firefox |


  Scenario Outline: I should be able successfully login to the system
    Given I open the browser "<browser>"
    Given I delete the cookies
    When I  visit GittiGidiyor web page
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/"
    When I click login button
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/uye-girisi"
    When I enter username as "merbraven@gmail.com"
    And I enter password as "3598478m"
    And I click login enter button
    Then I should be able to see that I login to the system
    Then I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
#      | firefox |


  Scenario Outline: I should be able open the second page of the searched item which is "bilgisayar"
    Given I open the browser "<browser>"
    Given I delete the cookies
    When I  visit GittiGidiyor web page
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/"
    When I click login button
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/uye-girisi"
    When I enter username as "merbraven@gmail.com"
    And I enter password as "3598478m"
    And I click login enter button
    Then I should be able to see that I login to the system
    When I search "bilgisayar" in the search box
    Then I should see the search result
    When I go to the second search page
    Then I should see that second page has been opened
    Then I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
#      | firefox |


  Scenario Outline: I should be able select any computer item after getting search result by writing the item info to txt file
    Given I open the browser "<browser>"
    Given I delete the cookies
    When I  visit GittiGidiyor web page
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/"
    When I click login button
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/uye-girisi"
    When I enter username as "merbraven@gmail.com"
    And I enter password as "3598478m"
    And I click login enter button
    Then I should be able to see that I login to the system
    When I search "bilgisayar" in the search box
    Then I should see the search result
    When I go to the second search page
    Then I should see that second page has been opened
    When I select one of the computers
    Then I should be redirected to the the item page
    And I should be able to get the txt file including the item info and the price
    Then I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
#      | firefox |


  Scenario Outline: I should be able to compare the price of the item by looking at the cart and the general item page
    Given I open the browser "<browser>"
    Given I delete the cookies
    When I  visit GittiGidiyor web page
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/"
    When I click login button
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/uye-girisi"
    When I enter username as "merbraven@gmail.com"
    And I enter password as "3598478m"
    And I click login enter button
    Then I should be able to see that I login to the system
    When I search "bilgisayar" in the search box
    Then I should see the search result
    When I go to the second search page
    Then I should see that second page has been opened
    When I select one of the computers
    Then I should be redirected to the the item page
    When I add the item to the cart
    Then I check the price of the added item is same in the cart
    Then I check if the browser has been closed

    Examples:
      | browser |
      | chrome  |
#      | firefox |


  Scenario Outline: I should be able to check the amount has been increased to 2 and delete it from the cart
    Given I open the browser "<browser>"
    Given I delete the cookies
    When I  visit GittiGidiyor web page
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/"
    When I click login button
    Then I check if the page is correctly opened "https://www.gittigidiyor.com/uye-girisi"
    When I enter username as "merbraven@gmail.com"
    And I enter password as "3598478m"
    And I click login enter button
    Then I should be able to see that I login to the system
    When I search "bilgisayar" in the search box
    Then I should see the search result
    When I go to the second search page
    Then I should see that second page has been opened
    When I select one of the computers
    Then I should be redirected to the the item page
    When I add the item to the cart
    Then I go the cart
    When I increase the amount of the cart item to "2"
    Then The cart amount should be "2"
    When I click delete cart button
    Then The item should be deleted from the cart
    Then I check if the browser has been closed

    Examples:
      | browser |
      | chrome  |
#      | firefox |



