Scenario: User goes to Registration page
 
Given user is on Home page
When user opens Registration link
Then Registration page is shown


Scenario: User registers on the site

Given user is on Registration page
When user registers
Then Profile page is shown


Scenario: User searches for a product

Given user is on Home page
When user types phrase in search box
Then search result is displayed

