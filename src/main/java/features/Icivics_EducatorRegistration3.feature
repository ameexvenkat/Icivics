Feature: Educator Registration ValidationPage3

Scenario: C348 - Can you tell which page you are currently viewing in the breadcrumbs?
Given Launch the icivis educatorregistration URL
Then verify Current page count 3 and print

Scenario: C349 - Can you select Back to proceed to the previous page?
Given Verify clicking on back button will take to previous page 2

Scenario: C350 - When you go Back, are your entries in all fields remembered?
Given Verify Grade Level is remembered.
When Verify Role is remembered.

Scenario: C351 - Do you see fields for School or Institution, Zip Code, and Teaching State?
Given User on Page 3, Verify School or institution field is displayed
When User on Page 3, Verify Zip Code field is displayed
And User on Page 3, Verify Teaching State dropdown is displayed
And Verify options in the Teaching State dropdown

Scenario: C352 - Can you enter text/make a selection for all fields?
Given Verify enter School or institution name in the textbox
When Verify enter Zip code must be in proper 5 or 9 digit form
And Verify Teaching state selection from dropdown is working fine
And Verify zipcode display error msg if the zipcode is more than 9 digits

Scenario: C354 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?
Given Enter invalid School, Zipcode as none for Teacherstate and verify the error messages.

Scenario: C355 - If you leave a required field blank and select Next, do you receive an appropriate error message?
Given Click on next without entering any valid data in School, Zipcode as none for Teacherstate and verify the error messages.

Scenario: C357 - If you fill out all required fields with valid information and select Next, are you taken to Page 4?
Given Verify select vaild options and click on next button
Then verify page 4 is loaded

