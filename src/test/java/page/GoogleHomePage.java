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
     *"searchField" variable declaration and initialization at the moment when the variable uses via @FindBy.
     */
    @FindBy(id = "lst-ib")
    private WebElement searchField;

    /**
     *"submitButton" variable declaration and initialization at the moment when the variable uses via @FindBy.
     */
    @FindBy(xpath = "//input[@aria-label='Пошук Google']")
    private WebElement submitButton;

    /**
     * Constructor of GoogleHomePage class which takes WebDriver instance from GoogleBasePage class
     * and initializes @FindBy GoogleHomePage class WebElements via PageFactory
     * @param webDriver - webdriver instance
     */
    public GoogleHomePage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method which verifies if the search filed is displayed on the web page.
     * In case when search field is visible method confirms that web page is loaded.
     * Method extended from GoogleBasePage.
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = searchField.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }

    /**
     * Method which enters search therm into search filed and click to submit button.
     * @param searchWord - therm which uses for search
     * @return - new GoogleSearchPage class
     */
    public GoogleSearchPage searchByTerm(String searchWord) {
        searchField.sendKeys(searchWord);
        submitButton.click();
        return new GoogleSearchPage(webDriver);
    }
}
