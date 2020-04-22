package testcases;

import Pages.AddingNewCustomer;
import Pages.SearchingCustomerById;
import Pages.SearchingCustomerByName;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseClass;

public class SearchingCustomerByNameTests extends BaseClass {
    public WebDriver driver;
    public SearchingCustomerByName searchingCustomerByName;
    public AddingNewCustomer addingNewCustomer;

    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();
        loginTest(driver);
    }

    @BeforeMethod
    void objectInitialization(){
        searchingCustomerByName = new SearchingCustomerByName(driver);
    }

    @Test
    void SearchTestByEmail(){
        addingNewCustomer = new AddingNewCustomer(driver);
        addingNewCustomer.clickCustomerMenu();
        addingNewCustomer.clickCustomerMenuItem();
        searchingCustomerByName.setSearchFirstName("Victoria");
        searchingCustomerByName.setSearchLastName("Terces");
        searchingCustomerByName.clickSearchButton();
        searchingCustomerByName.searchByName("Victoria" , "Terces");
    }

    @AfterClass
    void teardown(){
        driver.close();
        driver.quit();
    }

}
