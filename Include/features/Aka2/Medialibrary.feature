
@tag
Feature: Thực hiện mở trang medialibrary và thêm mới

   #@tag1
  #Scenario Outline: Thực hiện vào trang Medialibrary và thêm mới
    #Given Thực hiện mở hệ thống và nhập <username> và <password>
    #When Nhấn Login để thực hiện đăng nhập
    #And Đăng nhập thành công và mở màn hình trang chủ
    #And Thêm mới một Medialibrary
    #Then Hoàn thành thêm mới và đóng hệ thống
#
    #Examples: 
      #| name  | username | password  |Test|
      #| name1 |testuser  | akv@2030testuser |Meo|
      
  @tag2
  Scenario Outline: Thực hiện tìm kiếm và xóa media
    Given Thực hiện mở hệ thống và nhập <username> và <password>
    When Nhấn Login để thực hiện đăng nhập
    And Đăng nhập thành công và mở màn hình trang chủ tìm kiếm
    And Tìm kiếm media và xóa media
    Then Hoàn thành thêm mới và đóng hệ thống

    Examples: 
      | name  | username | password  |Test|
      | name1 |testuser  | akv@2030testuser |a|