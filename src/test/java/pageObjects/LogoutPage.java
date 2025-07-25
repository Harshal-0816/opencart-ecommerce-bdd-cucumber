package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogoutPage extends BasePage
{
    //constructor
    public LogoutPage (WebDriver driver)
    {
        super(driver);
    }

    //locators
    @FindBy(xpath="//div[@id='content']//h1[text()='Account Logout']") WebElement LogoutMessage;
    @FindBy(xpath="//div//a[@class='btn btn-primary']") WebElement LogoutContinue;

    //action methods
    public String cnf_logout_msg()
    {
        return LogoutMessage.getText();
    }

    public void click_logout_continue()
    {
        LogoutContinue.click();
    }
}
