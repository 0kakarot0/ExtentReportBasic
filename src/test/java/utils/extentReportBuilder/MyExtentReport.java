package utils.extentReportBuilder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class MyExtentReport {
    private WebDriver driver;
    ExtentSparkReporter spark;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public MyExtentReport(WebDriver driver) {
        this.driver = driver;

    }

    //Created Extent Report Html File
    public void extentReporter() {
        Date date = new Date();
        String rightNow = "Spark"+ date.getTime() + ".html" ;
        String pathOfFile = "allReports/"+rightNow;
        spark = new ExtentSparkReporter(pathOfFile);

        extentReports = new ExtentReports();
        extentReports.attachReporter(spark);
    }

    public void logTestNameAndDescription(String name, String description){
        extentTest = extentReports.createTest(name, description);
    }

    public void logTestInfo(String testInfo){
        extentTest.log(Status.INFO,testInfo);
    }

    public void logPassedTestSteps(String logPassMessage){
        extentTest.pass(logPassMessage);
    }
    public void logFailTestSteps(String logFailMessage){
        extentTest.fail(logFailMessage);
    }
    public void logFailTestScreenShot(String reasonOfFailure){
        extentTest.fail(reasonOfFailure,MediaEntityBuilder.createScreenCaptureFromPath("utils/failedTestScreenShot/screenshot.png").build());
    }

    public void flushExtentReport(){
        extentReports.flush();
    }


}
