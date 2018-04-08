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

    public GoogleBasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public String getPageTitle (){
        return webDriver.getTitle();
    }

    public String getCurrentURL (){
        return  webDriver.getCurrentUrl();
    }

    public void waitTillElementIsVisible (WebElement webElement, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public abstract boolean isLoaded();
}

