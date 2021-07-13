Feature: PetShop test

  Background:
    Given Is configured PetShop application on address 'https://petstore.swagger.io/'

  Scenario: Test GET for existing element
    Given on server '' exist entity on endpoint 'v2/pet/' with id 1
    When users sends 'GET' request to 'v2/pet/1' endpoint
    Then service returns response 200
    And service return pet with id 1

  Scenario: Test GET for not existing element
    Given on server 'not' exist entity on endpoint 'v2/pet/' with id 1
    When users sends 'GET' request to 'v2/pet/1' endpoint
    Then service returns response 404
