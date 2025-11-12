Feature: Read states from Excel
  As a tester
  I want to read a column from Excel
  So that I can use the values in my tests

  Scenario: Load 'State Name' list
    Given I read the "Users" sheet column "State Name" from "testdata.xlsx"
    Then I should have 10 products

  Scenario: Load 'State Name' list
    Given I read the "Sheet1" sheet column "First Name" from "sample_test_data_3_columns.xlsx"
    Then I should have 10000 products

  @excel
  Scenario: Validate registrations
    Given user is navigated to registration page
    When user searches with product name from "Sheet1" sheet column "First Name" in "sample_test_data_3_columns.xlsx"
    Then data should be displayed correctly