package za.co.stepdefinition;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import za.co.baseclass.BaseClass;
import za.co.pages.AppointmentConfirmationPage;
import za.co.pages.LoginPage;
import za.co.pages.MakeAppointmentPage;

public class StepDefinition extends BaseClass {

    public LoginPage theLoginPage = new LoginPage();
    public MakeAppointmentPage theAppointmentPage = new MakeAppointmentPage();
    public AppointmentConfirmationPage theConfirmationPage = new AppointmentConfirmationPage();
    private String responseBody="";


    @Given("user is on loginPage")
    public void user_is_on_login_page() {
       driver =  initiateDriver(properties.getProperty("browser"));
    }
    @When("user login the facility center")
    public void user_login_the_facility_center() {
        theAppointmentPage =  theLoginPage.loginUser(properties.getProperty("userName"), properties.getProperty("password"));

    }
    @Then("user selects {string} as facility center and comment as {string} and book the appointment")
    public void user_selects_as_facility_center_and_comment_as_and_book_the_appointment(String facilityCenter, String comments) {
        theAppointmentPage.fillAppointmentForm(facilityCenter,comments);
    }
    @Then("user confirms the appointment in the selected facility center {string}")
    public void user_confirms_the_appointment_in_the_selected_facility_center(String string) {
        String facilityCenterName = theConfirmationPage.returnFacilityName();
        System.out.println("Facility Center Name Is: "+facilityCenterName);
    }
    @Then("user close the browser")
    public void user_close_the_browser() {
       closeDriver();
    }
    @Given("user has the API {string}  and it is available")
    public void user_has_the_api_and_it_is_available(String uri) {
        RestAssured.baseURI = uri;
        RequestSpecification httpRequest = RestAssured.given().relaxedHTTPSValidation();
        Response response = httpRequest.request(Method.GET);
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @When("user makes the GET api call {string}")
    public void user_makes_the_get_api_call(String apiUri) {
        RestAssured.baseURI = apiUri;
        RequestSpecification httpRequest = RestAssured.given().relaxedHTTPSValidation();
        Response response = httpRequest.request(Method.GET);
        responseBody = response.getBody().asString();
    }
    @Then("user gets the current rate of GBP currency")
    public void user_gets_the_current_rate_of_gbp_currency() throws ParseException {

        System.out.println((String)JsonPath.read(responseBody,"$.bpi.GBP.rate"));

    }
}
