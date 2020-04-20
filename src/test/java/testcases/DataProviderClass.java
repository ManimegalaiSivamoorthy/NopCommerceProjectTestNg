package testcases;

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

    @DataProvider(name = "EmptyEmailDataProvider")
    public Object[][] getEmptyEmailData(){
        return new Object[][]{{"", "admin"}, {"", "admin123"}};
    }
}
