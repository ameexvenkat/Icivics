Feature: Educator Registration ValidationPage4

Scenario: C358 - Can you tell which page you are currently viewing in the breadcrumbs?
Given Launch the icivis educatorregistration URL
Then verify Current page count 4 and print

Scenario: C359 - Can you select Back to proceed to the previous page?
Given Verify clicking on back button will take to previous page 3

Scenario: C360 - When you go Back, are your entries in all fields remembered?
Given Verify School or institution is remembered.
When Verify Zip Code is remembered.
And Verify Teaching State is remembered.

Scenario: C361 - Do you see fields for Password, Confirm Password, Sign Up for Emails, and Agree to Terms of Use/Privacy Policy?
Given User on Page 4, Verify Password field is displayed
When User on Page 4, Verify Confirm Password field is displayed
And User on Page 4, Verify Sign Up for Emails field is displayed
And Verify Agree to Terms of Use & Privacy Policy fields are displayed

Scenario: C362 - Is the Sign Up for emails box checked by default?
Given Verify if the Sign Up for emails box is checked by default

Scenario: C363 - Can you enter text/make a selection for all fields?
Given Verify Password and confirm allow to enter text and both match
When Verify Password must not be blank check it accepts weak passwords
And Verify Accept terms must be checked

Scenario: C364 - Are required fields marked with an asterisk?
Given Verify Password is marked with an asterisk
When Verify Confirm Password is marked with an asterisk

Scenario: C365 - If you hover over the password field, do you see a hover tooltip with appropriate text?
Given Hover on password field and verify the Tooltip Text

Scenario: C366 - When you enter text in the Password field, do you see text indicating the current password's strength?
Given Verify the password strength Indicator is changing according to password strength

Scenario: C367 - When you enter text in the Confirm Password field do you see text indicating whether the two passwords match?
Given Verify Password match indicator says yes or no depending on match with the confirm Password

Scenario: C368 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?
Given Enter invalid Password, Confirm Password and verify the error message and its displayed in red

Scenario: C369 - If you leave a required field blank and select Next, do you receive an appropriate error message?
Given Click on next without entering any valid data and verify the error messages.

Scenario: C370 - Do all error messages display correctly?
Given Verify Error message is in pink box at the top

Scenario: C371 - If you fill out all required fields with valid information and select Finish, are you taken to Page 5?
Given Verify with vaild inputs and click on next button
Then verify page 5 is loaded