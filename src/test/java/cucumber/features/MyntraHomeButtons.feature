@Candidate
  Feature: Myntra Home page buttons.

    Scenario Outline: Validate home page buttons.
      Given User is on home page and taps Categories
      When User clicks Studio <index>
      When User clicks on Profile
      And User clicks on Home
      Then Verify Explore button
      Examples: First and Second jobs
        | index |
        | 0     |
#        | 1     |
