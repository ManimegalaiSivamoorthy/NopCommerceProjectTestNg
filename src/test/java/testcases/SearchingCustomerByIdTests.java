package testcases;

import Pages.AddingNewCustomer;
import Pages.SearchingCustomerById;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseClass;

public class SearchingCustomerByIdTests extends BaseClass {
    public WebDriver driver;
    public SearchingCustomerById searchingCustomerById;
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
        searchingCustomerById = new SearchingCustomerById(driver);
    }

    @Test
    void SearchTestByEmail(){
        addingNewCustomer = new AddingNewCustomer(driver);
        addingNewCustomer.clickCustomerMenu();
        addingNewCustomer.clickCustomerMenuItem();
        searchingCustomerById.setSearchTextEmail("victoria_victoria@nopCommerce.com");
        searchingCustomerById.clickSearchButton();
        searchingCustomerById.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
    }

    @AfterClass
    void teardown(){
        driver.close();
        driver.quit();
    }

}
