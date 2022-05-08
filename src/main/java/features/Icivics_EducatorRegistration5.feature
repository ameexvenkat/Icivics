Feature: Educator Registration ValidationPage5

Scenario:Can you tell which page you are currently viewing in the breadcrumbs?


Scenario: Do you see a notification that a welcome message has been sent to your email address?
Then verify the message

Scenario: Do you see text that your confirmation email is on the way?
Then:  Verify Message says confirmation email is on its way

Scenario: Is your email displayed on the page?

Scenario: Can you select a button to resend your confirmation email?
And Verifybutton is clickable
