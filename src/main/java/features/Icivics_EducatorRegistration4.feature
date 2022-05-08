Feature: Educator Registration ValidationPage4

Scenario: Can you tell which page you are currently viewing in the breadcrumbs?


Scenario: Can you select Back to proceed to the previous page?
Then: click on back button

Scenario: Do you see fields for Password, Confirm Password, Sign Up for Emails, and Agree to Terms of Use/Privacy Policy?
Then Validate all the fields for page4

Scenario:Is the Sign Up for emails box checked by default?
Then validate the check box for signup

Scenario: Can you enter text/make a selection for all fields?
Then enter data in fields 

Scenario: Are required fields marked with an asterisk?

Scenario: Are required fields marked with an asterisk?

Scenario: If you hover over the password field, do you see a hover tooltip with appropriate text?
Then Hovered password field

Scenario: When you enter text in the Password field, do you see text indicating the current password's strength?
Then Validate the password strength

Scenario: When you enter text in the Confirm Password field do you see text indicating whether the two passwords match?
Then enter text in confirm password 

Scenario: If you enter invalid information in a required field and select Next, do you receive an appropriate error message?
Then Errors are displayed in red

Scenario: If you leave a required field blank and select Next, do you receive an appropriate error message?


Scenario: Do all error messages display correctly?

Scenario: If you fill out all required fields with valid information and select Finish, are you taken to Page 4?
Then enter all data and click on finish 
