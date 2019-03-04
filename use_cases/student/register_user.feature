Feature: Register user
  Description: The administrator registers a user of the library
  Actors: Administrator

  Scenario: Register a user
    Given that the administrator is logged in
    And there is a user with CPR "020563-4886", name "Helena M. Bertelsen", e-mail "HelenaMBertelsen@rhyta.com "
    And the user has address street "Slåenhaven 50", post code 4560, and city "Vig"
    When the administrator registers the user
    Then the user is a registered user of the library

  Scenario: Register a user when not the administrator
    Given that the administrator is not logged in
    And there is a user with CPR "020563-4886", name "Helena M. Bertelsen", e-mail "HelenaMBertelsen@rhyta.com "
    And the user has address street "Slaaenhaven 50", post code 4560, and city "Vig"
    When the administrator registers the user
    Then I get the error message "Administrator login required"

  Scenario: Register a user that is already registered
    Given a user is registered with the library
    And that the administrator is logged in
    When the administrator registers the user again
    Then I get the error message "User is already registered"