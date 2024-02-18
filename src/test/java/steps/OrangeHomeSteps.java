package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import pages.OrangeHomeObjects;

public class OrangeHomeSteps extends PageObject {

    OrangeHomeObjects orangeHomeObjects;

    @Step
    public void enterUsername(String username){
        orangeHomeObjects.usernameTxtBox.type(username);

    }
    @Step
    public void enterPassword(String password){
        orangeHomeObjects.passwordTxtBox.type(password);

    }

    @Step
    public void clickSubmitButton(){
        clickOn(orangeHomeObjects.submitButton);

    }



}
