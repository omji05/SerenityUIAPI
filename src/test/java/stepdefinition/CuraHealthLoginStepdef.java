package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.CuraHealthLoginSteps;
import steps.MakeAppointmentSteps;

public class CuraHealthLoginStepdef {
    @Steps
    CuraHealthLoginSteps curaHealthLoginSteps;
    @Steps
    MakeAppointmentSteps makeAppointmentSteps;

    private static final Logger LOGGER = LoggerFactory.getLogger(CuraHealthLoginStepdef.class);
    @When("user open the application")
    public void user_open_the_application() {
        curaHealthLoginSteps.open();
    }
    @And("user enters {string} as username and {string} as password")
    public void user_enters_as_username_and_as_password(String username, String password) {
        curaHealthLoginSteps.enterUsername(username);
        LOGGER.info("Entered Username");
        curaHealthLoginSteps.enterPassword(password);
        LOGGER.info("Entered Password");
        curaHealthLoginSteps.clickSubmitButton();
        LOGGER.info("CLicked on submit button");

    }
    @And("user should be able to successfully login")
    public void user_should_be_able_to_successfully_login() {
        makeAppointmentSteps.verifyHeading();
    }



}
