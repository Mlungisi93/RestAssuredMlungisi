package com.expleo.restassured.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class AuthorNameByIdSteps {
    private RequestSpecification reqSpec; //value which is used for request
    private ResponseSpecification respSpec; //value used for response
    private int blogId; // value used for our request to return data

    /*
     *Method set the blog id value and makes the request
     * @param blogId is the value used to set the blogId value
     */
    @Step
    public void submitBlogIdAs(int blogId) {
        setBlogId(blogId); // set the blog id using setBlog method which initialize the blogId instant variable
        setReqSpec(); // make the request
    }

    /*
     *Method set the request with a uri with the base port number anf base path value
     * return the error message is the hamcrest assertion failed otherwise it returns nothing to handle the exception
     */
    private void setReqSpec() {
 String message = "";

 String uri = "http://10.9.10.139";
        int portNumber = 3000;
        String basePath = "/posts/";

            reqSpec = new RequestSpecBuilder()
                    .setBaseUri(uri)
                    .setPort(portNumber)
                    .setBasePath(basePath)
                    //.addPathParam("code",code) // TODO Remover if not required
                    .build();
    }

    /*
    *Method that dispays is green on the report id the assert true but otherwise it print the error in detail
     */
    @Step
    public void i_shouldRecieveAuthorNameAs(String expectedAuthorName) {
        setRespSpec(expectedAuthorName); // sets the response
        recivedResponseAs();
    }
/*
*Method to display the response on the terminal
 */
    @Step
    private void recivedResponseAs() {
        String blogId = getBlogId() + "";
        Response response = given(reqSpec, respSpec)
                .get(blogId);
        response.then().log().all();
    }

    /*
    *Method set the response and check if the expected author name match the author value returned by response
    * @parma expectedAuthorName - is the string value we was to assert from the response
     * return the error message is the hamcrest assertion failed but otherwise it returns nothing to handle the exception
     */
    @Step
    private void setRespSpec(String expectedAuthorName) {


            respSpec = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .expectBody("author", equalTo(expectedAuthorName))
                    .build();

    }

    /*
     * @return blog id is the value we use to search
     */
    public int getBlogId() {
        return blogId;
    }

    /*
     *method to initialise the blog id
     * @param blog id - is the value we use to serach
     */
    public void setBlogId(int blogId) {

        this.blogId = blogId;
    }

    /*
     *method to print out the catched error is it exits
     * @message -will be the returned error from setResponse if there is any
     */
    @Step("{0}")
    public void message(String message) {

    }

}
