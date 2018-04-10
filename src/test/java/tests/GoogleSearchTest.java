package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.GoogleSearchPage;
import java.util.List;

/**
 * Created by Vika on 08.04.18.
 */
public class GoogleSearchTest extends GoogleBaseTest {

    /**
     * Data store which provides search therms for the method searchTest
     */
    @DataProvider
    public Object[][] searchTest() {
        return new Object[][]{
                {"selenium"},
                {"SELENIUM"}
        };
    }

    /**
     * Test which verifies search on the google web page and verifies quantity of search results on the first and second pages.
     * @param searchWord - therm which uses for search
     */
    @Test(dataProvider = "searchTest")
    public void searchTest(String searchWord)  {

        String initialPageTitle = homePage.getPageTitle();
        GoogleSearchPage searchPage = homePage.searchByTerm(searchWord);
        Assert.assertNotEquals(initialPageTitle, homePage.getPageTitle(), "Page with search results is not opened");

        Assert.assertTrue(searchPage.isLoaded(), "Page with search results is not opened");

        List<String> resultsFromFirstPage = searchPage.getResults();

        Assert.assertEquals(resultsFromFirstPage.size(), 10,
                "Expected size of results is not 10" );

        for (String result: resultsFromFirstPage){
            Assert.assertTrue(result.toLowerCase().contains(searchWord.toLowerCase()),
                    "Search results does not contain search therm in element" );
        }
        Assert.assertTrue(searchPage.navigateToSecondPage(), "Second page is not opened");

        List<String> resultsFromSecondPage = searchPage.getResults();

        Assert.assertEquals(resultsFromSecondPage.size(), 10,
                "Expected size of results is not 10" );

        for (String result: resultsFromSecondPage){
            Assert.assertTrue(result.toLowerCase().contains(searchWord.toLowerCase()),
                    "Search results does not contain search therm in element" );

    }
} }
