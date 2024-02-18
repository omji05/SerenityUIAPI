package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CuraHealthLoginObjects extends PageObject {


    @FindBy(id="txt-username")
    public WebElementFacade curaUsernameTxtBox;

    @FindBy(id="txt-password")
    public WebElementFacade curaPasswordTxtBox;

    @FindBy(id="btn-login")
    public WebElementFacade curaLoginBtn;





}
