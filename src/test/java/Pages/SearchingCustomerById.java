package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utils;

import java.util.List;

public class SearchingCustomerById {
    public WebDriver driver;
    public Utils utils;
    public SearchingCustomerById(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new Utils(driver);
    }

    //locating elements on the web page

    @FindBy(xpath = "//input[@id='SearchEmail']")
    @CacheLookup
    WebElement searchTextEmail;

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

    // action methods

    public void setSearchTextEmail(String email){
        utils.waitForSeconds(2);
        searchTextEmail.clear();
        searchTextEmail.sendKeys(email);
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

    public Boolean searchCustomerByEmail(String email){
        for(int i=1; i< getNoOfRows(); i++){
            String id = driver.findElement(By.xpath("//table[@id = 'customers-grid']//tbody/tr["+ i +"]/td[2]")).getText();
            if(id.equals(email)){
                return true;
            }
        }
        return false;
    }
}
