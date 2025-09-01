Feature: Verify Team Member API

@FetchTeam
Scenario Outline: Check filtered data using Store ID and Department
Given User successfully login on the portal
When Click on Team Member using filter
Then Data should be filtered according to the selected filter
 
#Examples: 
#
#|GroupId                             |storeId                              


@TeamMember
Scenario: Find the ACTIVE & INACTIVE Teammembers
Given User successfully login on the portal
When  Click on Team Member using filter
Then Find the count of active and inactvive teammembers using "getallteammembersTB" API.

 
