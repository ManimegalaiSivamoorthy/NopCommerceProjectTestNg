package testcases;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests{
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    void objectInitialization(){
        loginPage = new LoginPage(driver);
    }

    /***
     * This test case is for validating whether the login is successful given the correct emailId and password
     * @param emailId
     * @param password
     */
    @Test(priority = 1, dataProviderClass = DataProviderClass.class, dataProvider = "SuccessLoginDataProvider")
    void loginTest(Object emailId, Object password){
        loginPage.setTextEmail((String) emailId);
        loginPage.setTextPassword((String) password);
        clickLoginForValidCredentials();
        clickLogout();
    }

    /***
     * This test case is for validating whether the login page error is thrown when invalid emailId and password
     * @param emailId
     * @param password
     */
    @Test(priority = 2, dataProviderClass = DataProviderClass.class, dataProvider = "FailureLoginDataProvider")
    void loginTestForInvalidCredentials(Object emailId, Object password){
        loginPage.setTextEmail((String) emailId);
        loginPage.setTextPassword((String) password);
        clickLoginForInValidCredentials();
    }

    /***
     * This test case is for validating whether the login page error is thrown when empty emailId and password
     * @param emailId
     * @param password
     */
    @Test(priority = 3, dataProviderClass = DataProviderClass.class, dataProvider = "EmptyEmailDataProvider")
    void loginTestWithoutEmail(Object emailId, Object password){
        loginPage.setTextEmail((String) emailId);
        loginPage.setTextPassword((String) password);
        clickLoginForEmptyEmail();
    }

    public void clickLoginForValidCredentials(){
        loginPage.clickLoginButton();
        Assert.assertEquals("Dashboard / nopCommerce administration", loginPage.getTitle());
    }

    private void clickLoginForInValidCredentials(){
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.getPageSource().contains("Login was unsuccessful."));
    }

    private void clickLoginForEmptyEmail(){
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.findElement(By.id("Email-error")).isDisplayed());
    }

    private void clickLogout(){
        loginPage.clickLogoutButton();
        Assert.assertEquals("Your store. Login", loginPage.getTitle());
    }

    @AfterClass
    void teardown(){
        driver.close();
        driver.quit();
    }
}
