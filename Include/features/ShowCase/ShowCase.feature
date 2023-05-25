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
Feature: Thực hiện kiểm tra tính năng showcase và thêm showcase mới 

  #@tag1
  #Scenario Outline: Truy cập vào phân hệ showcase
    #Given User thực hiện truy cập web và đăng nhập với username : <username> và password : <password>
    #When User thực hiện mở trang showcase
    #Then Hệ thống hiển thị table danh sách của trang showcase
#
    #Examples: 
      #| username | password         |
      #| testuser | akv@2030testuser |

  @themmoishowcase
  Scenario Outline: User thực hiện thêm mới bản tin
    Given User thực hiện truy cập web và đăng nhập với username : <username> và password : <password>
    When User thực hiện mở trang showcase
    And User thực hiện bấm vào add new
    And User thực hiện nhập thông tin thêm mới gồm title showcase : <title_showcase> , nội dung showcase : <noidung_showcase>
    And User thực hiện thêm mới ảnh feature image và logo
    And User thực hiện chọn category , position và tab cho ở màn hình showcase
    And User thực hiện nhập thông tin web
    And user thực hiện chọn hình
    And User bấm vào publist showcase
    Then Hệ thống hiển thị thông báo publish showcase thành công

    Examples: 
      | username | password         | title_showcase | noidung_showcase |
      | testuser | akv@2030testuser | test           | test             |
