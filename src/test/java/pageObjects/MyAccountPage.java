package pageObjects;

import factory.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
    //Constructor
    public MyAccountPage(WebDriver driver)
    {
        super(driver);
    }

    //locators
    @FindBy(xpath="//div[@id='content']//h2[text()='My Account']") WebElement MyAccountLogo;
    @FindBy(xpath="//span[@class='caret']") WebElement dropdown_myacc;
    @FindBy(xpath="//li//a[text()='Logout']") WebElement btnLogout;

    //action methods
    public boolean logo_myacc()
    {
        return MyAccountLogo.isDisplayed();
    }

    public void Myaccdrpdwn()
    {
        dropdown_myacc.click();
    }

    public void clicklogout()
    {
        btnLogout.click();
    }



}
