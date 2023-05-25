
@tag
Feature: Thực hiện chức năng bookmarks

  @ThemMoiBookmarkThanhCong
  Scenario Outline: Thực hiện vào trang bookmarks và thêm mới
    Given Thực hiện mở hệ thống và nhập <username> và <password>
    When Nhấn Login để thực hiện đăng nhập
    And Đăng nhập thành công và thực hiện mở màn hình trang chủ
    And Thêm mới một <Test> bookmark
    Then Hoàn thành thêm mới và đóng hệ thống

    Examples: 
      | name  | username | password  |Test|
      | name1 |testuser  | akv@2030testuser |Meo|


  @tag2
  Scenario Outline: Thực hiện tìm kiếm bookmarks
    Given Thực hiện mở hệ thống và nhập <username> và <password>
    When Nhấn Login để thực hiện đăng nhập
    And Đăng nhập thành công và thực hiện mở màn hình trang chủ
    And Tìm kiếm <Test> bookmark và xóa bookmark
    Then Hoàn thành thêm mới và đóng hệ thống

    Examples: 
      | name  | username | password  |Test|
      | name1 |testuser  | akv@2030testuser |Meo|
      
      