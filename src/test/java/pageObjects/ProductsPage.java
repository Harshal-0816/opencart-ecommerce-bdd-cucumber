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
    @FindBy(xpath="//p[text()='There is no product that matches the search criteria.']") WebElement NoProductFound;
    @FindBy(xpath="//div[@class='caption']//h4") WebElement ProductLink;

    //ActionMethods
    public List<WebElement> ProductsList()
    {
        return ProductsList;
    }

    public String Msg_NoProductFound()
    {
        return NoProductFound.getText();
    }

    public void lnk_Product()
    {
        ProductLink.click();
    }
}
