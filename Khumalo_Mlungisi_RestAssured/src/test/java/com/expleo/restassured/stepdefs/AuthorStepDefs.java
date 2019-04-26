package com.expleo.restassured.stepdefs;

import com.expleo.restassured.steps.AuthorNameByIdSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AuthorStepDefs {
    int blogId = 6; // the blog is
    String expectedAuthorName = "Danica"; // the expected value we are passing

    @Steps
    AuthorNameByIdSteps testSteps; // AuthorNameByIdSteps object intantiation

    /*
    Method found in Blog.feature as a step in the scenario
     */
    @Given("^I am using valid blog id$")
    public void iAmUsingValidBlodId() {
        //nothing really to do here
    }

    /*
   Method found in Blog.feature as a step in the scenario
    */
    @When("^I submit a valid blog id$")
    public void iSubmitAValidBlodId() {
        testSteps.submitBlogIdAs(blogId); //calls the submit methos from authorNameByIdSteps
    }

    /*
   Method found in Blog.feature as a step in the scenario
    */
    @Then("^I recieve the correct author$")
    public void iRecieveTheCorrectAuthor() {
        testSteps.i_shouldRecieveAuthorNameAs(expectedAuthorName);
    }
}
