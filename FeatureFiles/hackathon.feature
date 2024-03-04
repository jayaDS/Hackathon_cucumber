Feature: Finding Hospitals
 Scenario: displays Doctors
			Given User present on practo.com Website_one 
			When User enters city Bangalore in seachbox
			And User clicks on Bangalore option
			And User enters Medical specialist Cardiologist in seachbox
			And User clicks on Cardiologist option
			And User applies filters
			Then User displays the first five Doctors
 Scenario: displays surgeries
	    Given User present on practo.com Website_two 
	    When User clicks on Surgeries 
	    Then User displays the Surgeries list
 Scenario: Health and Wellness Plan form validation
 		  Given User present on practo.com Website_three  
	    When User clicks on For Corporates
	    And User clicks on Health and Wellness Plan
	    And User enters all non-email fields in the form
	    And User enters invalid email
	    Then validate if Schedule a Demo button is disabled
	    When User enters valid email
	    And User clicks on Schedule a Demo button 
	    Then validate if Thank You message is displayed  
	    