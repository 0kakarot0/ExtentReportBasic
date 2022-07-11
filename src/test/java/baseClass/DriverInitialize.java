package baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.GoogleSearchPage;
import utils.extentReportBuilder.MyExtentReport;

public class DriverInitialize {

    private WebDriver driver;
    protected GoogleSearchPage searchPage;
    protected MyExtentReport extentReport;

    @BeforeSuite
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        extentReport = new MyExtentReport(driver);
        searchPage = new GoogleSearchPage(driver);

        extentReport.extentReporter();
        extentReport.logTestNameAndDescription("Google Search","Searching text in the google Search");
        extentReport.logTestInfo("Starting the Google Search Test Case");
        driver.get("https://www.google.com");
        extentReport.logPassedTestSteps("Navigated to the Google website successfully");
    }

    @AfterSuite
    public void closeDriver() {
        extentReport.flushExtentReport();
        driver.close();
        driver.quit();
    }
}
