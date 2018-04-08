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

    @DataProvider
    public Object[][] searchTest() {
        return new Object[][]{
                {"selenium"},
                {"SELENIUM"}
        };
    }

    @Test(dataProvider = "searchTest")
    public void searchTest(String searchWord)  {

        GoogleSearchPage searchPage = homePage.searchByTerm(searchWord);
        Assert.assertTrue(searchPage.isLoaded(), "Page with search results is not opened");

        List<String> resultsFromFirstPage = searchPage.getResults();

        System.out.println(resultsFromFirstPage);

        Assert.assertEquals(resultsFromFirstPage.size(), 10,
                "Expected size of results is not 10" );

        for (String result: resultsFromFirstPage){
            Assert.assertTrue(result.toLowerCase().contains(searchWord.toLowerCase()),
                    "Search results does not contain search therm in element" );
        }
        Assert.assertTrue(searchPage.navigateToSecondPage(), "Second page is not opened");

        List<String> resultsFromSecondPage = searchPage.getResults();

        System.out.println(resultsFromSecondPage);

        Assert.assertEquals(resultsFromSecondPage.size(), 10,
                "Expected size of results is not 10" );

        for (String result: resultsFromSecondPage){
            Assert.assertTrue(result.toLowerCase().contains(searchWord.toLowerCase()),
                    "Search results does not contain search therm in element" );

    }
} }
