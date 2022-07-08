Feature: Login to the Pexapark Asset management application to create an asset, update and then delete the same asset.


  Background: Login to the Pexapark Asset management application
    Given user is on the home page
    When the user enters username
    And the user enters password
    And click on the login page submit button
    Then the user should land on the asset page that shows the list of existing assets

  @regression
  Scenario: Validating the asset name field
    Given the user is on the assets page
    When the user enters the short asset name and valid capacity factor
    And the user clicks on the submit button
    Then asset name too short error message should display
    And the user navigates back to the asset page
    When the user enters the very long asset name and valid capacity factor
    And the user clicks on the submit button
    Then asset name too long error message should display

  @smoke @regression
  Scenario: Create an asset
    Given the user is on the assets page
    When the user enters the asset name
    And the user enters the capacity factor
    And the user clicks on the submit button
    Then a new asset is created with the given asset name and capacity factor

  @smoke @regression
  Scenario: Updating an existing asset
    Given the user is on the assets page
    When the user click on edit button of an existing asset
    Then the user is navigated to the Edit Asset page
    And the user enters the new asset name
    And the user enters the new capacity factor
    And the user click on the submit button
    Then the selected asset should be updated with the new asset name and the new capacity factor

  @smoke @regression
  Scenario: Deleting an existing asset
    Given the user is on the assets page
    When the user click on delete button of an existing asset
    Then the asset should be deleted and should not display in the list of assets