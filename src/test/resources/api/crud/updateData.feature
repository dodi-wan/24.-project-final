

@api
Feature: update data existing

  Description:
  "id": "60d0fe4f5311236168a109e7",
  "title": "mr",
  "firstName": "Joey", //change name
  "lastName": "Oliver", // change name
  "picture": "https://randomuser.me/api/portraits/med/men/61.jpg"

  Scenario Outline: Test update data dummy api
    Given update data "<id>" "<firstName>" "<lastName>"
    Then response should be 200

    Examples:
      | id                        | firstName | lastName |
      | 60d0fe4f5311236168a109ec  | Paman     | Robot    |