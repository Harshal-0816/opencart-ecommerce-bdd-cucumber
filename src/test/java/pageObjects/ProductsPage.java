package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage
{
    //constructor
    public ProductsPage(WebDriver driver)
    {
        super(driver);
    }

    //locators
    @FindBy(xpath="//div[@class='caption']//h4//a") List<WebElement> ProductsList;

    //ActionMethods
    public List<WebElement> ProductsList()
    {
        return ProductsList;
    }
}
