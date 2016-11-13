Feature: Test all the scenarios for hotel management system as part of capgemini interview exam 
Background: 
Given when I login to the hotel management system using "admin" and "password"

#Scenario 1
#Create an entry
@test1 @all
Scenario: Create an entry into the hotel management system
When enter HotelName as "PremiereInn"
And I enter Address as "40 Moorgate"
And I enter Owner as "George Michel"
And I enter phone number as "07000000001"
And I enter email address as "george.michael@hotel.com"
When I click on Button "create"
Then Then entry should be added on to the page


#Scenario 2
#Delete an entry
@test2 @all
Scenario: Delete an entry
When I click the X mark next to the hotel entry row with username "PremiereInn"
Then The corresponding entry should be deleted

#Scenario 3
#Create multiple entries
@test3 @all
Scenario Outline: Create an entry into the hotel management system
When enter HotelName as "<HotelName>"
And I enter Address as "<Address>"
And I enter Owner as "<Owner>"
And I enter phone number as "<phone>"
And I enter email address as "<email>"
When I click on Button "create"
Then Then entry should be added on to the page

Examples: 
|HotelName		|Address			|Owner			|phone			|email					|
|Expedia		|20 Aldwich road	|Taylor Swift	|07000000002	|taylor.swift@hotel.com	|
|HolidayInn		|45 Park Lane		|Harry Styles	|07000000003	|harry.styles@hotel.com	|
|Radison		|50 Hyde Park		|Sam Smith		|07000000004	|sam.smith@hotel.com	|
|Hyatt			|221b Baker Street	|Sherlock homes	|07000000005	|sher.homes@gmail.com	|
|Hilton			|1 Strand			|David Beckham	|07000000006	|david.beckham@gmail.com|







