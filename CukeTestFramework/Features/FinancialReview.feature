@FinReviewPage
Feature: Financial Review subscription Page

     
  Scenario Outline: 001_FinReviewPageTest_001_Pop Check
    Given As FinancialReview User , I'm on the '<pageUrl>' subscription Page
     Then I should see subscriptionPrompt appears on the subscription Page
     And I Scroll to bottom of window
    When I wait for '10' seconds
    Then I should see subscriptionPrompt disappears on the subscription Page     
     Examples:
     |pageUrl| 
     |https://www.afr.com/policy/foreign-affairs/capability-edge-and-keeping-south-china-sea-open-crucial--christopher-pyne-20180924-h15rq9|