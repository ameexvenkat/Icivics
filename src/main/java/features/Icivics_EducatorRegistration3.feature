Feature: Educator Registration ValidationPage3

Scenario: Can you tell which page you are currently viewing in the breadcrumbs?


Scenario: Can you select Back to proceed to the previous page?
Then click on back button

Scenario: 

Scenario: Do you see fields for School or Institution, Zip Code, and Teaching State?
When all the fields filled for page 1,page 2 validate page 3 fields 

Scenario: Can you enter text/make a selection for all fields? 
Then provide data to page3 fields 

Scenario: If you enter invalid information in a required field and select Next, do you receive an appropriate error message?
Then After submit, error message appears list errors

Scenario: If you leave a required field blank and select Next, do you receive an appropriate error message?
Then After submit, error message appears list errors

Scenario:If you fill out all required fields with valid information and select Next, are you taken to Page 4?
When Goes to page 4

