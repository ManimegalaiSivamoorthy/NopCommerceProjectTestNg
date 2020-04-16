package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utils;

public class LoginPage {

    public WebDriver driver;
    public Utils utils;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utils = new Utils(driver);
    }

    @FindBy(id = "Email")
    @CacheLookup
    WebElement textEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement textPassword;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    @CacheLookup
    WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    @CacheLookup
    WebElement logoutButton;

    //Action Methods

    public void setTextEmail(String email){
        utils.WaitForElement(textEmail,30);
        textEmail.clear();
        textEmail.sendKeys(email);
    }

    public void setTextPassword(String password){
        utils.WaitForElement(textPassword, 30);
        textPassword.clear();
        textPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        utils.WaitForElement(loginButton,30);
        loginButton.click();
    }

    public void clickLogoutButton(){
        utils.WaitForElement(logoutButton,30);
        logoutButton.click();
    }

    public String getTitle(){
        String title;
        title = driver.getTitle();
        return title;
    }
}
