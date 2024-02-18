package stepdefinition;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import steps.OrangeHomeSteps;

public class OrangeHomeStepdef {

    @Steps
    OrangeHomeSteps orangehomesteps;

//    @When("user open the application")
//    public void user_open_the_application() {
//        orangehomesteps.open();
//    }
//    @When("user enters {string} as username and {string} as password")
//    public void user_enters_as_username_and_as_password(String username, String password) {
//        orangehomesteps.enterUsername(username);
//        orangehomesteps.enterPassword(password);
//        orangehomesteps.clickSubmitButton();
//
//    }
//    @Then("user should be able to successfully login")
//    public void user_should_be_able_to_successfully_login() {
//
//    }
}
