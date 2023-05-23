#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login vào hệ thống 

  @tag1
  Scenario Outline: User thực hiện đăng nhập vào hệ thống aka
    Given User thực hiện truy cập vào hệ thống
    When User nhập thông tin <username> và <password>
    Then User thực hiện bấm login
    And Hệ thống thông báo thành công và chuyển tới màn hình dashboard

    Examples: 
      | username | password         |
      | testuser | akv@2030testuser |
