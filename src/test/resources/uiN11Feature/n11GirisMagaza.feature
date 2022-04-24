@all
Feature: All Stores
  Scenario: user verify the All Stores menu
    Given user goes to N11 Home Page
    Then user verifies "N11 Home Page"
    Then user clicks Magazalar menu
    Then user clicks Tum Magazalar menu
    And user selects A harfindeki tum magazalar
    Then user verifies the title of all subcategories
