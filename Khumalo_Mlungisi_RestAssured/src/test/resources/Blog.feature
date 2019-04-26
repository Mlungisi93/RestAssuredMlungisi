Feature: Retrieve author by id

  As a blog user
  I want to be able to search for an author of the blog by using id
  so that I can confirm the author of the blog

  Scenario: Get author name from one integer blog id value

    Given I am using valid blog id
    When I submit a valid blog id
    Then I recieve the correct author