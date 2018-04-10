package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vika on 08.04.18.
 */
public class GoogleSearchPage extends GoogleBasePage{

    /**
     *"listOfResults" webelement declaration and initialization of it's locator via @FindBy annotation.
     */
    @FindBy(xpath = "//div[@class= 'srg']//div[@class= 'g']")
    private List<WebElement> listOfResults;

    /**
     *"searchStatus" webelement declaration and initialization of it's locator via @FindBy annotation.
     */
    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement searchStatus;

    /**
     *"secondPage" webelement declaration and initialization of it's locator via @FindBy annotation.
     */
    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement secondPage;


    /**
     * Constructor of GoogleHomePage class which takes WebDriver instance from GoogleBasePage class
     * and initializes @FindBy GoogleHomePage class WebElements via PageFactory
     * @param webDriver - webdriver instance
     */
    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method which verifies if the search status is displayed on the web page.
     * In case when search status is visible method confirms that web page is loaded.
     * Method extended from GoogleBasePage.
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = searchStatus.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }

    /**
     * Method which waits until search status is visible on the web page and gets search results
     * @return list of results in String
     */
    public List<String> getResults() {

        waitTillElementIsVisible(searchStatus, 5);
        List<String> resultStringList = new ArrayList();
        for (WebElement element: listOfResults){
            String cardTitle = element.getText();
            element.getTagName();
            resultStringList.add(cardTitle);
        }
        return resultStringList;
    }


    /**
     * Method which click to the webelement secondPage to navigate into it.
     */
    public boolean navigateToSecondPage(){
        secondPage.click();
        return true;
    }

}
