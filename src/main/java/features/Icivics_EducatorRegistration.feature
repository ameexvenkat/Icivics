Feature: C320 - Educator Registration Validation

Scenario: C321 - Are all page elements consistent with those on Live?
Given Launch the icivis educatorregistration URL
When Educatorregistration page is verified successfully
And Pagecounter is verified successfully
And Username verified successfully
And Reload button verified
And Firstname is verified successfully
And Lastname is verified successfully
And Email is verified successfully
And Verify Email is verified successfully
Then click on next button

Scenario: C322 - Do all buttons have hover/click states consistent with Live?
When Validate play button on hovering getting highlighted
And Validate teach button on hovering getting highlighted
And Validate about button on hovering getting highlighted
And Validate donate button on hovering
And Validate shop button on hovering
And Verify signin button on hovering getting highlighted
And Firstname field on hovering get highlighted
And Lastname field on hovering get highlighted
And Email field on hovering should highlighted
And Verify Email field on hovering should highlighted
And Validate Nextbutton on hovering getting highlighted

Scenario: C323 - Do all buttons/links navigate you to the appropriate page?
When On teach page, check all links of Play button
Then check all links of teach button
Then check all links of about button
Then check all links of Donate button

Scenario: C324 - Does the page resize responsively at different resolutions?
When window is resize it should be usable

Scenario: C325 - Is all copy correct?
When click on next button check spelling for alert msgs

Scenario: C326 - Do you see a set of 5 numbered page breadcrumbs?
When Pagecounter is verified successfully