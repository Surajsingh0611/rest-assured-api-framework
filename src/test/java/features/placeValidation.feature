Feature: Validate Place APIs
@addPlace
Scenario Outline: Verify Add Place API functionality
  Given Add Place Payload with "<name>" "<language>" "<address>"
  When User calls "AddPlaceAPI" with "POST" http request
  Then API call got success with status code 200
  And "scope" in response body is "APP"
  And "status" in response body is "OK"
  And verify place_id created maps to "<name>" using "GetPlaceAPI"
  
Examples:
  | name        | language | address          |
  | My Place    | English  | 123 Main St     |
#  | Another Place | French   | 456 Elm St      |

@deletePlace
Scenario: Verify if Delete Place API is working
Given DeletePlace Payload
When User calls "DeletePlaceAPI" with "POST" http request
Then API call got success with status code 200
And "status" in response body is "OK"