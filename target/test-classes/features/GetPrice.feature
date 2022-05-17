Feature: Get Price of Currency
  Scenario: Get rate of GBP
    Given user has the API "https://api.coindesk.com/v1/bpi/currentprice.json"  and it is available
    When user makes the GET api call "https://api.coindesk.com/v1/bpi/currentprice.json"
    Then user gets the current rate of GBP currency