Feature: Fetch Virtual account details


Scenario: Verify Account no and EnterpriseID
Given  Email id and Password
When   User will login using email id and password with "Fetchviraccount" API using "Post" method.
Then   API will automatically call for Virtual Account details with "Status" code "200".
And    "EnterpriseID" will fetch in Account details.
And    "Accountno" will fetch in response.
 







