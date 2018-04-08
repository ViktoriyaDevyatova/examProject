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

    @FindBy(xpath = "//div[@class= 'srg']//div[@class= 'g']")
    private List<WebElement> listOfResults;

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement searchStatus;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement secondPage;

    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = searchStatus.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }

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


    public boolean navigateToSecondPage(){
        secondPage.click();
        return true;
    }

//    public List<String> getResultsFromSecondPage() {
//
//        waitTillElementIsVisible(searchStatus, 5);
//        List<String> resultTwoStringList = new ArrayList();
//        for (WebElement elementSecond: listOfResults){
//            String cardTitleFromSecondPAge = elementSecond.getText();
//            resultTwoStringList.add(cardTitleFromSecondPAge);
//            }
//        return resultTwoStringList;
//    }
}
