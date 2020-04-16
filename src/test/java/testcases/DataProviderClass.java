package testcases;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderClass {
    @DataProvider(name = "SuccessLoginDataProvider")
    public  Object[][] getValidLoginData(){
        return new Object[][]{{"admin@yourstore.com", "admin"}};
    }

    @DataProvider(name = "FailureLoginDataProvider")
    public  Object[][] getInvalidLoginData(){
        return new Object[][]{
                {"admin123@yourstore.com", "admin123"},
                {"admin@yourstore.com",""},
                {"ksdh@gmail.com", ""}};
    }
}
