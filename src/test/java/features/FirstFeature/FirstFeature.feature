Feature: Google Search

  Background: To Launch the browser
    Given Launch the browser

  Scenario: Search for Cucumber in Google
    When Hit Google on your browser
    Then Enter "Cucumber" in the search text box.
    And Select the first result.