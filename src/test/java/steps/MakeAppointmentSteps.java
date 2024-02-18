package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import pages.MakeAppointmentObjects;

public class MakeAppointmentSteps extends PageObject {

    MakeAppointmentObjects makeAppointmentObjects;

    @Step
    public void verifyHeading(){
        try {
            wait(5000);
        }
        catch(Exception e){
        }
        Assert.assertEquals(makeAppointmentObjects.makeAppointmentHeading.getText(),"Make Appointment");
    }

    @Step
    public void selectFacility(String facility){
        selectFromDropdown(makeAppointmentObjects.facilityDropdown,facility);
    }

    @Step
    public void selectHealthCareProgram(String healthcareProgram){
        clickOn(makeAppointmentObjects.medicAidRadioBtn);
    }

    @Step
    public void setDate(String date){
        typeInto(makeAppointmentObjects.dateTxtBox,date);
    }


    @Step
    public void addComment(String comment){
        typeInto(makeAppointmentObjects.commentTextBox,comment);
    }

    @Step
    public void clickBookAppointment(){
        makeAppointmentObjects.bookAppointmentButton.click();
        waitABit(10000);
    }


}
