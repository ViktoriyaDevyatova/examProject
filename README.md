# examProject
Exam project for QA Automation course

Project created to verify search process on the google.com.ua web page.
Project consists of:
- Page folder - contains pages with methods which uses in the test;
- Test folder - contains search test to verify search and search results;
- Search_test_chrome.xml - test suite for chrome browser;
- Search_test_firefox.xml - test suite for firefox browser;

Project also contains best practices of usage OOP and PageObject/PageFactory patterns for Java/WebDriver/TestNG project.

How to run tests from this project:
- Install JDK 1.8 or above corresponding to your OS
- Install Maven command line utility corresponding to your OS
- Make sure that following command line commands mvn -version and java -version give you information on mvn and java installed in your OS. Otherwise go back to #1 and #2 and google for proper installation guides.
- Clone repository with source code via Git
- In command line to cd to project root folder

To run test from command line use following command:
mvn clean install -DsuiteName=search_test_chrome.xml
where search_test_chrome.xml is a name of specific TestNG xml file with tests.
