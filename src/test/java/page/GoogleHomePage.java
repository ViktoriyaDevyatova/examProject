package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vika on 08.04.18.
 */
public class GoogleHomePage extends GoogleBasePage {

    /**
     *Find the search field on the web page
     */
    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(xpath = "//input[@aria-label='Пошук Google']")
    private WebElement submitButton;

    public GoogleHomePage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = searchField.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }

    public GoogleSearchPage searchByTerm(String searchWord) {
        searchField.sendKeys(searchWord);
        submitButton.click();
        return new GoogleSearchPage(webDriver);
    }
}
