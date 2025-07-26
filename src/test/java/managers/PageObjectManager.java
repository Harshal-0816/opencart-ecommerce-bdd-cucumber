package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager
{
    private WebDriver driver;

    private AccountRegistrationPage registrationPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private LogoutPage logoutPage;
    private MyAccountPage myAccountPage;
    private ProductsPage productsPage;

    public PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }

    public AccountRegistrationPage getRegistrationPage()
    {
        if( registrationPage == null)
        {
            registrationPage = new AccountRegistrationPage(driver);
        }
        return registrationPage;
    }

    public HomePage getHomePage()
    {
        if(homePage == null)
        {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public LoginPage getLoginPage()
    {
        if(loginPage == null)
        {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public LogoutPage getLogoutPage()
    {
        if( logoutPage == null)
        {
            logoutPage = new LogoutPage(driver);
        }
        return logoutPage;
    }

    public MyAccountPage getMyAccountPage()
    {
        if(myAccountPage == null)
        {
            myAccountPage = new MyAccountPage(driver);
        }
        return myAccountPage;
    }

    public ProductsPage getProductsPage()
    {
        if(productsPage == null)
        {
            productsPage = new ProductsPage(driver);
        }
        return productsPage;
    }

}
