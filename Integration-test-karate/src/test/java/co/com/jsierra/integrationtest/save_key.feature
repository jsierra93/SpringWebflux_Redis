Feature: Save key from API

  Background:
    * def urlApi = host + urlBase
    * def messageSchema = read('schemas/message.json')

  Scenario: Validate save value from key
    Given url urlApi
    And path 1
    And request { id: 'MSG0001', message: 'Success' }
    When method POST
    Then status 201
    And match response == { id: 'MSG0001', message: 'Success' }
    And match $.id == '#notnull'
    And match $.message == '#notnull'
    And match response == messageSchema