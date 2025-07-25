package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	//Contructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//span[text()='My Account']")  WebElement lnkMyaccount;
	@FindBy(linkText = "Register") WebElement lnkRegister;
	@FindBy(linkText = "Login") WebElement linkLogin;
	@FindBy(xpath="//input[@placeholder='Search']") WebElement txtSearchbox;
	@FindBy(xpath="//div[@id='search']//button[@type='button']") WebElement btnSearch;
	@FindBy(xpath = "//div[@id='logo']//h1//a[text()='Qafox.com']") WebElement Logo;
	@FindBy(xpath="//div[contains(text(), 'Warning: ')]") WebElement Warning_Msg;

	// Action Methods
	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}

	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()// added in step6
	{
		linkLogin.click();
	}
	
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}
	
	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}
	
	public boolean Logo_Displayed()
	{
        return Logo.isDisplayed();
	}

	public String Invalid_login_msg()
	{
		return Warning_Msg.getText();
	}
}
