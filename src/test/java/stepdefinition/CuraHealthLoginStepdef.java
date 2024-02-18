package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.CuraHealthLoginSteps;
import steps.MakeAppointmentSteps;

public class CuraHealthLoginStepdef {
    @Steps
    CuraHealthLoginSteps curaHealthLoginSteps;
    @Steps
    MakeAppointmentSteps makeAppointmentSteps;

    @When("user open the application")
    public void user_open_the_application() {
        curaHealthLoginSteps.open();
    }
    @And("user enters {string} as username and {string} as password")
    public void user_enters_as_username_and_as_password(String username, String password) {
        curaHealthLoginSteps.enterUsername(username);
        curaHealthLoginSteps.enterPassword(password);
        curaHealthLoginSteps.clickSubmitButton();

    }
    @And("user should be able to successfully login")
    public void user_should_be_able_to_successfully_login() {
        makeAppointmentSteps.verifyHeading();
    }



}
