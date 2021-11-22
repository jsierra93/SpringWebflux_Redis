Feature: get key from API

    Background:
      * def urlApi = host + urlBase
      * def messageSchema = read('schemas/message.json')
      * def saveKey = call read('save_key.feature')

  Scenario: Validate get value from key
      Given url urlApi
      And path 1
      When method GET
      Then status 200
      And match response == { id: 'MSG0001', message: 'Success' }
      And match $.id == '#notnull'
      And match $.message == '#notnull'
      And match response == messageSchema
