package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class OrangeHomeObjects extends PageObject {

//    public WebElementFacade usenameTextbox=$("//input[@name='username']");
//    public WebElementFacade passwordTextBox=$("//input[@name='password']");

//    public WebElementFacade submitButton=$(By.xpath("//button[@type='submit']"));


    @FindBy(name="username")
    public WebElementFacade usernameTxtBox;
    @FindBy(name="password")
    public WebElementFacade passwordTxtBox;
    @FindBy(xpath="//button[@type='submit']")
    public WebElementFacade submitButton;


}
