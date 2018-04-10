package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GoogleHomePage;

/**
 * Created by Vika on 08.04.18.
 */
public class GoogleBaseTest {
    WebDriver webDriver;
    GoogleHomePage homePage;


    /**
     *Method which runs before every test to open web browser
     * @param browserType - type of the webdriver to use
     * @param url - url to navigate to
     */
    @Parameters({"browserType", "url"})
    @BeforeMethod
    public void beforeTest(@Optional("chrome") String browserType, @Optional("https://www.google.com.ua/") String url){

        switch (browserType.toLowerCase()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            default:
                System.out.println("Unsupported browser");
                break;
        }

        webDriver.navigate().to(url);

        homePage = new GoogleHomePage(webDriver);
    }

    /**
     * Method which runs after every test to close web browser
     */
    @AfterMethod
    public void afterTest(){
        webDriver.close();
    }


}
