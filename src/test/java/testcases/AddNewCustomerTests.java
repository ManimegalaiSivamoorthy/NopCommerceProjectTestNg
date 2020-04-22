package testcases;

import Pages.AddingNewCustomer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseClass;
import utilities.Utils;

public class AddNewCustomerTests extends BaseClass {
    public WebDriver driver;
    AddingNewCustomer addingNewCustomer;
    Utils utils;


    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();
        loginTest(driver);
        utils = new Utils(driver);
    }

    @BeforeMethod
    void objectInstantiate() {
        addingNewCustomer = new AddingNewCustomer(driver);
    }


    @Test(priority = 1)
    void addCustomerData() {
        addingNewCustomer.clickCustomerMenu();
        addingNewCustomer.clickCustomerMenuItem();
        addingNewCustomer.clickAddNewButton();
        getCustomerInformation();
        addingNewCustomer.clickSaveButton();
        utils.waitForSeconds(3);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='alert alert-success alert-dismissable']")).getText()
                .contains("The new customer has been added successfully"));

    }

    public void getCustomerInformation() {
        addingNewCustomer.setTextEmail(randomEmailGeneration() + "@gmail.com");
        addingNewCustomer.setTextPassword("abc");
        addingNewCustomer.setTextFirstName("John");
        addingNewCustomer.setTextLastName("Peter");
        addingNewCustomer.setGender("Male");
        addingNewCustomer.setDateOfBirth("4/6/87");
        addingNewCustomer.setCompanyName("Microsoft");
        addingNewCustomer.setCustomerRoles("Guests");
        addingNewCustomer.setDropDownManagerOfVendor("Vendor 2");
        addingNewCustomer.setAdminContent("Testing..........");
    }

    @AfterClass
    void teardown() {
        driver.close();
        driver.quit();
    }
}
