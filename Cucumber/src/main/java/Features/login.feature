Feature: Free CRM LoginFeature

  #Without 'Examples' keyword
  #Scenario: Free CRM Login Test
  #
  #Given user is already on login page
  #When title of login page is Cogmento CRM
  #Then user enters "sikriwal.rahulraj@gmail.com" and "123Admin"
  #Then user clicks on login button
  #And user is on home page
  #With 'Examples' keyword
  #Scenario Outline: Free CRM Login Test
  #
  #Given user is already on login page
  #When title of login page is Cogmento CRM
  #Then user enters "<username>" and "<password>"
  #Then user clicks on login button
  #And user is on home page
  #
  #Examples:
  #		| username                    | password |
  #		| sikriwal.rahulraj@gmail.com | 123Admin |
  #Using DataTables
  #Scenario: Free CRM Login Test
    #Given user is already on login page
    #When title of login page is Cogmento CRM
    #Then user enters username and password
      #| sikriwal.rahulraj@gmail.com | 123Admin |
    #Then user clicks on login button
    #And user is on home page
    
    
    #Data driven using Map
  Scenario: Free CRM Login Test
    Given user is already on login page
    When title of login page is Cogmento CRM
    Then user enters username and password
      | username                    | password |
      | sikriwal.rahulraj@gmail.com | 123Admin |
    Then user clicks on login button
    And user is on home page
