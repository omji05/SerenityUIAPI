package stepdefinition;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import steps.MakeAppointmentSteps;
import utilities.CommonUtil;
import utilities.ExcelUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MakeAppointmentStepdef {
    @Steps
    MakeAppointmentSteps makeAppointmentSteps;
    CommonUtil commonUtil = new CommonUtil();



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


    @Given("we are able to read data from excel file {string} on tab {string}")
    public void we_are_able_to_read_data_from_excel_file_on_tab(String fileName, String sheetName) {
        List<Map<String,String>> data = commonUtil.getDataFromExcel(fileName,sheetName);
        System.out.println("data is "+data);

    }
}
