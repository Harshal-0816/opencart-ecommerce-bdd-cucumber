package stepDefinitions;

import org.junit.Assert;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.*;

import java.io.IOException;
import java.util.Properties;

public class Step_Def_UI {

     HomePage hp= new HomePage(BaseClass.getDriver());;
     LoginPage lp = new LoginPage(BaseClass.getDriver());;
     AccountRegistrationPage regpage = new AccountRegistrationPage(BaseClass.getDriver());
	 MyAccountPage myacc = new MyAccountPage(BaseClass.getDriver());
	 LogoutPage lop = new LogoutPage(BaseClass.getDriver());

	@Given("the user navigates to Register Account page")
	public void user_navigates_to_register_account_page()
	{
    	hp.clickMyAccount();
        hp.clickRegister();
	}
	
	@When("the user enters {string} {string} {string} {string} {string} {string}")
	public void the_user_enters(String fname, String lname,String email, String tel, String pwd, String cpwd)
	{
		regpage.setFirstName(fname);
		regpage.setLastName(lname);

		String Email=BaseClass.randomEmail();
		regpage.setEmail(Email);

		regpage.setTelephone(tel);
		regpage.setPassword(pwd);
		regpage.setConfirmPassword(cpwd);
	}

	@When("the user selects Privacy Policy")
	public void user_selects_privacy_policy()
	{
		regpage.setPrivacyPolicy();
	}

	@When("the user clicks on Continue button")
	public void user_clicks_on_continue_button()
	{
		regpage.clickContinue();
	}

	@Then("the user account should get created successfully")
	public void user_account_should_get_created_successfully()
	{
		try
			{
				String confmsg = regpage.getConfirmationMsg();
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
		hp.clickMyAccount();
		hp.clickLogin();
	}
	@When("user enters email and password")
	public void user_enters_email_and_password() throws IOException
	{
		try
			{
				Properties p = BaseClass.getProperties();
				String setEmail = p.getProperty("email");
				String setPwd = p.getProperty("password");

				lp.setEmail(setEmail);
				lp.setPassword(setPwd);
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
		lp.clickLogin();
	}
	@Then("the user should be redirected to the MyAccount Page")
	public void the_user_should_be_redirected_to_the_my_account_page()
	{
		try
			{
				boolean logo_myacc_status= myacc.logo_myacc();
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
		myacc.Myaccdrpdwn();
	}
	@When("user click on the Logout button")
	public void user_click_on_the_logout_button()
	{
		myacc.clicklogout();
	}

	@Then("user should be redirected to the logout page")
	public void user_should_be_redirected_to_the_logout_page()
	{
		try
			{
				String logoutMessage= lop.cnf_logout_msg();
				Assert.assertEquals("Logout message mismatch", "Account Logout", logoutMessage);
				lop.click_logout_continue();
				Thread.sleep(3000);
				boolean logo_display=hp.Logo_Displayed();
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
				lp.setEmail(Email);
				lp.setPassword(Password);
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
			String Warning_msg = hp.Invalid_login_msg();
			Assert.assertEquals("Error message mismatch", ExpectedErrorMessage, Warning_msg);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

	}
}

















