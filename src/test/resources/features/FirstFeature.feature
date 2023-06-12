
Feature: Verify and Functionality Testing of Prothom Alo


#TC_Home_001
  Scenario: Verify the Prothom Alo Application Title
    When Open Prothom Alo Home Page in browser
    Then Verify the title

#TC_Home_002
  Scenario: Verify side navigation bar is showing and work properly
    When Click on ham burger icon
    Then Click on home button on side navigation bar

#TC_Home_003
  Scenario: Verify Search News Functionality
    When Click on search icon
    Then input search keyword
    And Select first result

#TC_Login_001
  Scenario: Verify Functionality of login module
    When Click on Login Button
    Then Input Email And Password
    And Click Login Button

#TC_Login_002
  Scenario: Verify Login Profile
    When Open Login Profile
    Then Check profile Email

#TC_Login_003
  Scenario: Verify logout Functionality
    When Click Logout Button
    Then try to open profile

#TC_Login_004
  Scenario: Verify User and Password Validation Functionality
    When Input Email And Wrong Password
    Then Click Login
    And Check return error


#TC_Create_001
  Scenario: Verify the Email Validation Functionality
    Given Open Create Account Page
    When Enter valid Full Name Email Password Confirm Password
    Then Click Register Button
    And Check for name error

#TC_Create_002
  Scenario: Verify the Password Validation Functionality
    When Enter Name short Password
    Then Click Register
    And Check for password error

#TC_Create_003
  Scenario: Verify the Confirm Password Validation Functionality
    When Enter Name Password
    Then Click Register
    And Check for password matching error