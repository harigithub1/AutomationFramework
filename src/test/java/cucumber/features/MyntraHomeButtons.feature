@Local1
Feature: Myntra Home page buttons

  @MobileLocal
    @OnlineCloud
  Scenario Outline: Validate home page buttons.
    Given User is on home page
    When User clicks on Categories One
#      When User clicks Studio <index> Two
#      When User clicks on Explore Three
#      When User clicks on Profile Four
#      And User clicks on Home Five
#      Then Verify Explore button
    Examples:
      | index |
      | 0     |
#        | 1     |

  Scenario Outline: Validate home page buttons.
    Given User is on home page
    When User clicks on Categories One
    When User clicks Studio <index> Two
    When User clicks on Explore Three
    When User clicks on Profile Four
    And User clicks on Home Five
    Then Verify Explore button
    Examples:
      | index |
      | 0     |
      | 1     |