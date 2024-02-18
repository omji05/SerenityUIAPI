package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import pages.CuraHealthLoginObjects;

public class CuraHealthLoginSteps extends PageObject {


    CuraHealthLoginObjects curaHealthLoginObjects;

    @Step
    public void enterUsername(String username){
        curaHealthLoginObjects.curaUsernameTxtBox.type(username);

    }
    @Step
    public void enterPassword(String password){
        curaHealthLoginObjects.curaPasswordTxtBox.type(password);

    }

    @Step
    public void clickSubmitButton(){
        clickOn(curaHealthLoginObjects.curaLoginBtn);

    }
}
