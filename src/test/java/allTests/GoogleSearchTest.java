package allTests;

import baseClass.DriverInitialize;
import org.testng.annotations.Test;

public class GoogleSearchTest extends DriverInitialize {

    @Test
    public void googleSearch() {
        try {
            searchPage.enterSearchQuery("New Technology");
            extentReport.logPassedTestSteps("Enter the Search query in the Field Successfully");

            searchPage.clickOnGoogleSearchButton();
            extentReport.logPassedTestSteps("Clicked on the Search button Successfully");

            extentReport.logTestInfo("Test Completed");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
