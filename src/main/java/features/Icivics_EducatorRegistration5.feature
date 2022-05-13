Feature: Educator Registration ValidationPage5

Scenario: C372 - Can you tell which page you are currently viewing in the breadcrumbs?
Given Launch the icivis educatorregistration URL
Then verify Current page count 5 and print

Scenario: C373 - Do you see a notification that a welcome message has been sent to your email address?
Given verify Message says check your inbox

Scenario: C374 - Do you see text that your confirmation email is on the way?
Given  Verify Message says confirmation email is on its way

Scenario: C375 - Is your email displayed on the page?
Given Message has correct email from what was registered

Scenario: C376 - Can you select a button to resend your confirmation email?
And Verify resend button is clickable

Scenario: C377 - Do you see a notification when the email has been resent?
And Verify Screen shows confirmation email has been sent