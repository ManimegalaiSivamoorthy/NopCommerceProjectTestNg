package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Utils;

import java.time.temporal.WeekFields;

public class AddingNewCustomer {
    public WebDriver driver;
    public Utils utils;

    public AddingNewCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new Utils(driver);
    }

    //elements on the webPage
    @FindBy(xpath = "//a[@href='#']//span[contains(text(), 'Customers')]")
    @CacheLookup
    WebElement customersMenu;

    @FindBy(xpath = "//span[@class='menu-item-title'][contains(text(), 'Customers')]")
    @CacheLookup
    WebElement customersMenuItem;

    @FindBy(xpath = "//a[@class='btn bg-blue']")
    @CacheLookup
    WebElement addNewButton;

    @FindBy(xpath = "//input[@id='Email']")
    @CacheLookup
    WebElement textEmail;

    @FindBy(xpath = "//input[@id='Password']")
    @CacheLookup
    WebElement textPassword;

    @FindBy(xpath = "//input[@id='FirstName']")
    @CacheLookup
    WebElement textFirstName;

    @FindBy(xpath = "//input[@id='LastName']")
    @CacheLookup
    WebElement textLastName;

    @FindBy(xpath = " //input[@id='Gender_Male']")
    @CacheLookup
    WebElement radioButtonGenderMale;

    @FindBy(xpath = " //input[@id='Gender_Female']")
    @CacheLookup
    WebElement getRadioButtonGenderFemale;

    @FindBy(xpath = " //input[@id='DateOfBirth']")
    @CacheLookup
    WebElement dateOfBirth;

    @FindBy(xpath = " //input[@id='Company']")
    @CacheLookup
    WebElement companyName;

    @FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
    @CacheLookup
    WebElement customerRoles;

    @FindBy(xpath = "//li[@class='k-button']//span[contains(text(), Registered)]")
    @CacheLookup
    WebElement listItemRegistered;

    @FindBy(xpath = "//li[contains(text(), 'Administrators')]")
    @CacheLookup
    WebElement listItemAdministrators;

    @FindBy(xpath = "//li[contains(text(), 'Forum Moderators')]")
    @CacheLookup
    WebElement listItemForumModerators;

    @FindBy(xpath = "//li[contains(text(), 'Guests')]")
    @CacheLookup
    WebElement listItemGuests;

    @FindBy(xpath = "//li[contains(text(), 'Vendors')]")
    @CacheLookup
    WebElement listItemVendors;

    @FindBy(xpath = "//select[@id='VendorId']")
    @CacheLookup
    WebElement dropDownManagerOfVendor;

    @FindBy(xpath = "//textarea[@id='AdminComment']")
    @CacheLookup
    WebElement adminContent;

    @FindBy(xpath = "//button[@name =  'save']")
    @CacheLookup
    WebElement saveButton;

    //action methods

    public void clickCustomerMenu() {
        utils.waitForElement(customersMenu, 30);
        customersMenu.click();
    }

    public void clickCustomerMenuItem() {
        utils.waitForElement(customersMenuItem, 30);
        customersMenuItem.click();
    }

    public void clickAddNewButton() {
        utils.waitForElement(addNewButton, 30);
        addNewButton.click();
    }

    public void setTextEmail(String email){
        utils.waitForElement(textEmail, 30);
        textEmail.clear();
        textEmail.sendKeys(email);
    }

    public void setTextPassword(String password){
        utils.waitForElement(textPassword, 30);
        textPassword.clear();
        textPassword.sendKeys(password);
    }

    public void setTextFirstName(String firstName){
        utils.waitForElement(textFirstName, 30);
        textFirstName.clear();
        textFirstName.sendKeys(firstName);
    }

    public void setTextLastName(String lastName){
        utils.waitForElement(textLastName, 30);
        textLastName.clear();
        textLastName.sendKeys(lastName);
    }

    public void setGender(String gender){
        if(gender.equals("Male")){
            utils.waitForElement(radioButtonGenderMale, 30);
            radioButtonGenderMale.click();
        }else{
            utils.waitForElement(getRadioButtonGenderFemale, 30);
            getRadioButtonGenderFemale.click();
        }
    }

    public void setDateOfBirth(String dob){
        utils.waitForElement(dateOfBirth, 30);
        dateOfBirth.clear();
        dateOfBirth.sendKeys(dob);
    }

    public void setCompanyName(String name){
        utils.waitForElement(companyName, 30);
        companyName.clear();
        companyName.sendKeys(name);
    }

    public void setCustomerRoles(String roles) {
        if("Guests".equals(roles)){
            driver.findElement(By.xpath("//span[@class='k-icon k-delete']")).click();
        }
        customerRoles.click();
        utils.waitForSeconds(3);
        WebElement listItem;
        switch (roles){
            case "Administrators":
                listItem = listItemAdministrators;
                break;
            case "Forum Moderators":
                listItem = listItemForumModerators;
                break;
            case "Vendors":
                listItem = listItemVendors;
                break;
            default:
                listItem = listItemGuests;
                break;
        }
        listItem.click();
    }

    public void setDropDownManagerOfVendor(String vendor){
        utils.waitForElement(dropDownManagerOfVendor, 30);
        Select dropDown = new Select(dropDownManagerOfVendor);
        dropDown.selectByVisibleText(vendor);
    }

    public void setAdminContent(String message){
        utils.waitForElement(adminContent, 30);
        adminContent.clear();
        adminContent.sendKeys(message);
    }

    public void clickSaveButton(){
        utils.waitForElement(saveButton,30);
        saveButton.click();
    }
}
