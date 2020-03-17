Feature:User Registration
I want to check that user can register  in our e-commerce website.

Scenario Outline: User Registration

Given the user in the home page
When I click on Register link
And I entered "<firstname>", "<lastname>", "<email>", "<password>"
Then the registration page displayed successfully 

Examples:

| firstname | lastname | email | password |
| ahmed | mohamed | ahmed@ggg.com | 12345678|
| emy | mohamed | emy@ggg.com | 12345678|
