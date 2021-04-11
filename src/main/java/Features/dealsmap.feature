Feature: Deal data creation 
Scenario: Free CRM Login Test Scenario

Given user is present on Login Page
When title of login page will be is Free CRM
Then user enters the credentials "balasureshkumar946@gmail.com" and "Bala@15081995"
Then user needs to clicks on login button
Then user will navigate to home page
Then need to quit
Scenario: Free CRM Create a new deal scenario 

	Given Already on Login Page 
	When login page is Free CRM 
	Then user enters username and password 
		| username | password|
		| balasureshkumar946@gmail.com | Bala@15081995 |
		
	Then clicks on login button 
	Then is on home page 
	Then user moves to new deal page 
	Then user enters deal details 
		|title       | amount | probability | commission |
		| test deal1 | 1000 | 50 | 10 |
		| test deal2 | 2000 | 60 | 20 |
		| test deal3 | 3000 | 70 | 30 |
		
	Then wants to close the browser