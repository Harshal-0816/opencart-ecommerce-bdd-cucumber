package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage{

    //constructor
    public ProductDisplayPage(WebDriver driver)
    {
        super(driver);
    }

    //locators
    @FindBy(xpath="//div[@id='content']//div[@class='col-sm-4']//h1") WebElement ProductName;
    @FindBy(xpath="//div//button[@id='button-cart']") WebElement AddToCartButton;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible' and contains(text(), 'Success: You have added')]") WebElement AddToCartConfMessage;

    //ActionMethods
    public String NameOfProduct()
    {
        return ProductName.getText();
    }

    public void btn_AddToCart()
    {
        AddToCartButton.click();
    }

    public String ConfMsg_AddToCart()
    {
        return AddToCartConfMessage.getText();
    }
}
