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
Feature: Thực hiện mở trang và thêm mới page


  @tag1
  Scenario Outline: Thực hiện thêm mới page
    Given Thực hiện mở hệ thống và nhập <username> và <password>
    When Nhấn Login để thực hiện đăng nhập
    And Mở màn hình page
    And Thực hiện thêm mới một page <Test>
    Then Hoàn thành thêm mới và đóng hệ thống

    Examples: 
      | name  | username | password  |Test|
      | name1 |testuser  | akv@2030testuser |Meo|
      
    
  @tag2
  Scenario Outline: Thực hiện tìm kiếm
    Given Thực hiện mở hệ thống và nhập <username> và <password>
    When Nhấn Login để thực hiện đăng nhập
    And Mở màn hình page
    And Thực hiện tìm kiếm một page <Test>
    And Thực hiện xóa một page
    Then Hoàn thành thêm mới và đóng hệ thống

    Examples: 
      | name  | username | password  |Test|
      | name1 |testuser  | akv@2030testuser |Meo|
      