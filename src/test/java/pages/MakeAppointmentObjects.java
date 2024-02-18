package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MakeAppointmentObjects extends PageObject {


    @FindBy(xpath="//section[@id='appointment']//h2")
    public WebElementFacade makeAppointmentHeading;

    @FindBy(id="combo_facility")
    public WebElementFacade facilityDropdown;

    @FindBy(id="txt_comment")
    public WebElementFacade commentTextBox;

    @FindBy(id="txt_visit_date")
    public WebElementFacade dateTxtBox;

    @FindBy(id="btn-book-appointment")
    public WebElementFacade bookAppointmentButton;

    @FindBy(how = How.CSS, using = "[type='radio'][value='Medicare']")
    public WebElementFacade mediCareRadioBtn;

    @FindBy(how = How.CSS, using = "[type='radio'][value='Medicaid']")
    public WebElementFacade medicAidRadioBtn;

    @FindBy(how = How.CSS, using = "[type='radio'][value='None']")
    public WebElementFacade noneRadioBtn;



}
