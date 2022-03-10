@Local1
  Feature: Feature Myntra Home page buttons F1Local1  .

    @Local
    Scenario Outline: Scenario Validate home page buttons F1S1Local1.
      Given User is on home page
      When User clicks on Categories One
      When User clicks Studio <index> Two
      When User clicks on Explore Three
      When User clicks on Profile Four
      And User clicks on Home Five
      Then Verify Explore button
      Examples: First and Second jobs
        | index |
        | 0     |
#        | 1     |

    Scenario Outline: Scenario Validate home page buttons F1S2Local1.
      Given User is on home page
      When User clicks on Categories One
      When User clicks Studio <index> Two
      When User clicks on Explore Three
      When User clicks on Profile Four
      And User clicks on Home Five
      Then Verify Explore button
      Examples: First and Second jobs
        | index |
        | 0     |
        | 1     |
