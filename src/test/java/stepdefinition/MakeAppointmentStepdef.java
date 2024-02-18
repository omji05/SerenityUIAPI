package stepdefinition;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import steps.MakeAppointmentSteps;

public class MakeAppointmentStepdef {
    @Steps
    MakeAppointmentSteps makeAppointmentSteps;



    @And("user select facility as {string} from dropdown")
    public void userSelectFacilityAsFromDropdown(String facility) {
        makeAppointmentSteps.selectFacility(facility);

    }

    @And("user select healthcare program as {string} radio button")
    public void userSelectHealthcareProgramAsRadioButton(String healthCareProgram) {
        makeAppointmentSteps.selectHealthCareProgram(healthCareProgram);
    }

    @And("user select date as {string}")
    public void userSelectDateAs(String date) {
        makeAppointmentSteps.setDate(date);

    }

    @And("user update comment as {string}")
    public void userUpdateCommentAs(String comment) {
        makeAppointmentSteps.addComment(comment);
    }

    @And("user click on Book Appointment button")
    public void userClickOnBookAppointmentButton() {
        makeAppointmentSteps.clickBookAppointment();
    }

}
