Feature: Educator Registration ValidationPage1

Scenario: C338 - Can you tell which page you are currently viewing in the breadcrumbs?
Given Launch the icivis educatorregistration URL
Then verify Current page count 2 and print

Scenario: C339 - Can you select Back to proceed to the previous page?
Given Verify clicking on back button will take to previous page 1

Scenario: C340 - When you go Back, are your entries in all fields remembered (but not the randomly generated username)?
Given Verify Username is regenerated.
When Verify firstname is remembered.
And Verify lastname is remembered.
And Verify email is remembered.
And Verify verifyemail is remembered.

Scenario: C341 - Do you see fields for Role and Grade Level?
Given User on Page 2, Verify grade level field and option is displayed as checkbox and nothing is selected as default
When User on Page 2, Verify nothing is selected as default for grade level
And Verify role options in the dropdown

Scenario: C342 - Can you make a selection for all fields?
Given Verify Grade level can have >1 value selected
When Verify Role can have only 1 value selected

Scenario: C343 - If you select the Role 'Other' does an additional 'What is your role?' field appear?
Given Verify on selecting other from grade level dropdown display additional field

Scenario: C344 - Are required fields marked with an asterisk?
Given Verify Grade Level is marked with an asterisk
When Verify Role is marked with an asterisk
And Verify What is your role? is marked with an asterisk

Scenario: C345 - If you leave a required field blank and select Next, do you receive an appropriate error message?
Given Click on Next button and verify grade and role error msg
Then Click on Next button and verify grade and what is your role error msg

Scenario: C346 - Do all error messages display correctly?
Given Verify Error message is in pink box at top

Scenario: C347 - If you fill out all required fields with valid information and select Next, are you taken to Page 3?
Given Verify select vaild options and click on next button
Then verify page 3 is loaded