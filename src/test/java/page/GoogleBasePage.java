package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.mustache.StringChunk;

/**
 * Created by Vika on 08.04.18.
 */
public abstract class GoogleBasePage {

    WebDriver webDriver;

    /**
     * Constructor of GoogleBasePage which takes webdriver instance initialized in @BeforeMethod
     * for reuse in GoogleBasePage class methods
     * @param webDriver - webdriver instance
     */
    public GoogleBasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    /**
     * Method which gets current page title
     */
    public String getPageTitle (){
        return webDriver.getTitle();
    }

    /**
     * Method which waits untill WebElement is visible on the webpage
     * @param webElement - WebElement to wait for
     * @param timeoutInSeconds - waiting time in second
     */
    public void waitTillElementIsVisible (WebElement webElement, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Abstract method which must be implemented in all classes which extends from GoogleBasePage class
     */
    public abstract boolean isLoaded();
}

