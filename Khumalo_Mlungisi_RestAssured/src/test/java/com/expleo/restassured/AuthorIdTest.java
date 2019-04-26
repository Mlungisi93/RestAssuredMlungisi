package com.expleo.restassured;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class) //this integrates cucumber with serenity
@CucumberOptions(features = "src/test/resources",
glue = "com.expleo.restassured.stepdefs")//this integrates cucumber with serenity
public class AuthorIdTest {
}
