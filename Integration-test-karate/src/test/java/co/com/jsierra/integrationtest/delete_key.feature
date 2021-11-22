Feature: Delete key from API

  Background:
    * def urlApi = host + urlBase
    * def messageSchema = read('schemas/message.json')
    * def saveKey = call read('save_key.feature')

  Scenario: Validate save value from key
    Given url urlApi
    And path 1
    When method DELETE
    Then status 200
    And match response == 'true'