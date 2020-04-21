package utilities;

import Pages.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BaseClass {
    public WebDriver driver;
    LoginPage loginPage;


    public void loginTest(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        loginPage.setTextEmail("admin@yourstore.com");
        loginPage.setTextPassword("admin");
        clickLoginForValidCredentials();
    }


    public void clickLoginForValidCredentials() {
        loginPage.clickLoginButton();
        Assert.assertEquals("Dashboard / nopCommerce administration", loginPage.getTitle());
    }

    public String randomEmailGeneration(){
        return RandomStringUtils.randomAlphabetic(6);
    }

}
