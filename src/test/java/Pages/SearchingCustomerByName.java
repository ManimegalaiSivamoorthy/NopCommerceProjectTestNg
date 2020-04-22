package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utils;

import java.util.List;

public class SearchingCustomerByName {
    public WebDriver driver;
    public Utils utils;
    public SearchingCustomerByName(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new Utils(driver);
    }

    // locating elements needed

    @FindBy(xpath = "//input[@id='SearchFirstName']")
    @CacheLookup
    WebElement searchFirstName;

    @FindBy(xpath = "//input[@id='SearchLastName']")
    @CacheLookup
    WebElement searchLastName;

    @FindBy(xpath = "//button[@id='search-customers']")
    @CacheLookup
    WebElement searchButton;

    @FindBy(xpath = "//table[@id = 'customers-grid']")
    @CacheLookup
    WebElement table;

    @FindBy(xpath = "//table[@id = 'customers-grid']//tbody/tr")
    @CacheLookup
    List<WebElement> tableRows;

    @FindBy(xpath = "//table[@id = 'customers-grid']//tbody/tr/td")
    @CacheLookup
    List<WebElement> tableColumns;

    //action methods

    public void setSearchFirstName(String firstName){
        utils.waitForSeconds(2);
        searchFirstName.clear();
        searchFirstName.sendKeys(firstName);
    }

    public void setSearchLastName(String lastName){
        utils.waitForSeconds(2);
        searchLastName.clear();
        searchLastName.sendKeys(lastName);
    }

    public void clickSearchButton(){
        utils.waitForSeconds(2);
        searchButton.click();
    }

    public Integer getNoOfRows(){
        return tableRows.size();
    }

    public Integer getNoOfColumns(){
        return tableColumns.size();
    }

    public Boolean searchByName(String firstName, String lastName){
        for(int i =1; i < getNoOfRows(); i++){
            String name = driver.findElement(By.xpath("//table[@id = 'customers-grid']//tbody/tr[" + i + "]/td[3]" )).getText();
            if(name.equals(firstName + "" + lastName)){
                return true;
            }
        }
        return false;
    }
}
