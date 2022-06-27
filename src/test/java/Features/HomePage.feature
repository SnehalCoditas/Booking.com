Feature: Book hotel through Booking.com
  Scenario: User should able to book hotel
  Given User opens the browser
    When User select the place England
    Then Selects Checkin and checkout date with selection of child filter
    And User Selects on Search
    And User applies 5 star filter
    And User selects highest rated hotel