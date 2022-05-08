Feature: Educator Registration ValidationPage1

Scenario: Can you tell which page you are currently viewing in the breadcrumbs?



Scenario: Can you select Back to proceed to the previous page?
When Validate back button on clicking will take to previous page 

Scenario:  When you go Back, are your entries in all fields remembered (but not the randomly generated username)?


Scenario: Do you see fields for Role and Grade Level?
When Validate grade level field is present 
Then Validate role field is present 

Scenario: Can you make a selection for all fields?
When Validate Grade level can have >1 value selected
Then Validate Role can have only 1 value selected

Scenario: If you select the Role 'Other' does an additional 'What is your role?' field appear?
Then Validate on selecting other from dropdown display Other text field appears


Scenario: Are required fields marked with an asterisk?
 
Scenario: If you leave a required field blank and select Next, do you receive an appropriate error message?
Then Click on Next button and verify the error msg

Scenario: Do all error messages display correctly?
When Validate Error message is in pink box at top

Scenario: If you fill out all required fields with valid information and select Next, are you taken to Page 3?
Then Validate select the options and click on next button 