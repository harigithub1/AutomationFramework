@Local
  Feature: Myntra Home page buttons F2.

    Scenario Outline: Validate home page buttons F2S1.
      Given User is on home page One
      When User clicks on Categories Two
      When User clicks Studio <index> Three
      When User clicks on Explore Four
      When User clicks on Profile Five
      And User clicks on Home Six
      Then Verify Explore button
      Examples: First and Second jobs
        | index |
        | 0     |
#        | 1     |
