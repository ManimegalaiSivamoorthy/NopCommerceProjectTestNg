package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    WebDriver driver;

    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElement(WebElement element, long timeOutSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForSeconds(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception e){
            System.out.println("wait failed" + e);
        }
    }
}
