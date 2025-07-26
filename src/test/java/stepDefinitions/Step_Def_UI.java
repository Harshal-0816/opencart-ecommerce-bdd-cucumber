package stepDefinitions;

import io.cucumber.java.en.And;
import managers.PageObjectManager;
import org.junit.Assert;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.*;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Step_Def_UI {

	WebDriver driver;
	PageObjectManager pom;

	public Step_Def_UI()
	{
		this.driver=BaseClass.getDriver();
		this.pom=new PageObjectManager(driver);
	}

	@Given("the user navigates to Register Account page")
	public void user_navigates_to_register_account_page()
	{
    	pom.getHomePage().clickMyAccount();
        pom.getHomePage().clickRegister();
	}
	
	@When("the user enters {string} {string} {string} {string} {string} {string}")
	public void the_user_enters(String fname, String lname,String email, String tel, String pwd, String cpwd)
	{
		pom.getRegistrationPage().setFirstName(fname);
		pom.getRegistrationPage().setLastName(lname);

		String Email=BaseClass.randomEmail();
		pom.getRegistrationPage().setEmail(Email);

		pom.getRegistrationPage().setTelephone(tel);
		pom.getRegistrationPage().setPassword(pwd);
		pom.getRegistrationPage().setConfirmPassword(cpwd);
	}

	@When("the user selects Privacy Policy")
	public void user_selects_privacy_policy()
	{
		pom.getRegistrationPage().setPrivacyPolicy();
	}

	@When("the user clicks on Continue button")
	public void user_clicks_on_continue_button()
	{
		pom.getRegistrationPage().clickContinue();
	}

	@Then("the user account should get created successfully")
	public void user_account_should_get_created_successfully()
	{
		try
			{
				String confmsg = pom.getRegistrationPage().getConfirmationMsg();
				Assert.assertEquals("Your Account Has Been Created!", confmsg);
			}
		catch (Exception e)
			{
				e.printStackTrace();
				Assert.fail("Test failed due to exception: " + e.getMessage());
			}
	}

	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page()
	{
		pom.getHomePage().clickMyAccount();
		pom.getHomePage().clickLogin();
	}
	@When("user enters email and password")
	public void user_enters_email_and_password() throws IOException
	{
		try
			{
				Properties p = BaseClass.getProperties();
				String setEmail = p.getProperty("email");
				String setPwd = p.getProperty("password");

				pom.getLoginPage().setEmail(setEmail);
				pom.getLoginPage().setPassword(setPwd);
		    }
		catch (Exception e)
			{
				e.printStackTrace();
				Assert.fail("Test failed due to exception: " + e.getMessage());
			}

	}
	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() throws InterruptedException
	{
		pom.getLoginPage().clickLogin();
	}
	@Then("the user should be redirected to the MyAccount Page")
	public void the_user_should_be_redirected_to_the_my_account_page()
	{
		try
			{
				boolean logo_myacc_status= pom.getMyAccountPage().logo_myacc();
				Assert.assertTrue(logo_myacc_status);
			}
		catch (Exception e)
			{
				e.printStackTrace();
				Assert.fail("Test failed due to exception: " + e.getMessage());
			}
	}

	@When("user navigates to the Myaccount dropdown")
	public void user_navigates_to_the_myaccount_dropdown()
	{
		pom.getMyAccountPage().Myaccdrpdwn();
	}
	@When("user click on the Logout button")
	public void user_click_on_the_logout_button()
	{
		pom.getMyAccountPage().clicklogout();
	}

	@Then("user should be redirected to the logout page")
	public void user_should_be_redirected_to_the_logout_page()
	{
		try
			{
				String logoutMessage= pom.getLogoutPage().cnf_logout_msg();
				Assert.assertEquals("Logout message mismatch", "Account Logout", logoutMessage);
				pom.getLogoutPage().click_logout_continue();
				Thread.sleep(3000);
				boolean logo_display=pom.getHomePage().Logo_Displayed();
				Assert.assertTrue("Logo is not Displayed after logout", logo_display);
			}
		catch (Exception e)
			{
				e.printStackTrace();
				Assert.fail("Test failed due to exception: " + e.getMessage());
			}
	}

	@When("user enters {string} and {string}")
	public void userEntersEmailAndPassword(String Email, String Password)
	{
		try {
				pom.getLoginPage().setEmail(Email);
				pom.getLoginPage().setPassword(Password);
			}
		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@Then("System throws an error as {string}")
	public void systemThrowsAnErrorAs(String ExpectedErrorMessage)
	{
		try
		{
			String Warning_msg = pom.getHomePage().Invalid_login_msg();
			Assert.assertEquals("Error message mismatch", ExpectedErrorMessage, Warning_msg);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

	}

	@Given("user is able to see the Home Page")
	public void userIsAbleToSeeTheHomePage()
	{
		try
		{
			String Title = driver.getTitle();
			Assert.assertEquals("Title mismatch error", "Your Store", Title);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

	@When("user enters the product name {string} in the search bar")
	public void userEntersTheProductNameInTheSearchBar(String Product)
	{
		pom.getHomePage().txt_Search(Product);

	}

	@And("user clicks on the search button")
	public void userClicksOnTheSearchButton()
	{
		pom.getHomePage().btn_search();
	}

	@Then("user should be able to see the search products")
	public void userShouldBeAbleToSeeTheSearchProducts()
	{
		try
		{
			List<WebElement> ListOfProducts = pom.getProductsPage().ProductsList();
			boolean productFound=false;

			for (WebElement ProductsTexts : ListOfProducts)
			{
				String ProductName = ProductsTexts.getText();

				if (ProductName.equalsIgnoreCase("iPhone"))
				{
					productFound=true;
					break;
				}
				else if (ProductName.equalsIgnoreCase("MacBook Air"))
				{
					productFound=true;
					break;
				}
			}
			if(productFound)
			{
				Assert.assertTrue("Product Found", true);
			}
			else
			{
				Assert.fail("Product not found");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test Failed due to Exception" + e.getMessage());
		}


	}

	@Then("user should be able to see the message {string}")
	public void userShouldBeAbleToSeeTheMessage(String NoProductFoundMessage)
	{
		try
		{
			String Message = pom.getProductsPage().Msg_NoProductFound();
			Assert.assertEquals("Failed to find the 'No Product Found message'", "There is no product that matches the search criteria.", Message);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail("Failed due to Exception" + e.getMessage());
		}
	}
}































