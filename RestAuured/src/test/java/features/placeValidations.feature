
@tag
Feature: Validating place API's 
  I want to use this template for my feature file

  @AddPlace
  Scenario Outline: Verify if place is being successfuly added using add place API
    Given Add place Payload with "<name>" "<language>" "<address>"
    When User calls "AddPlaceAPI" with "POST" http request
    Then API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
	  Then verify place_Id created maps to "<name>" using "getPlaceAPI"


    Examples: 
      | name   | language | address           |
      | Ahouse | English  | WTC               |
 #     | Bhouse | Spanish  | Central Perk      |

@DeletePlace
Scenario: Verify if place is being successfuly deleted using delete place API
    Given DeletePlace Payload
    When User calls "deletePlaceAPI" with "POST" http request
    Then API call is success with status code 200
    And "status" in response body is "OK"
    
