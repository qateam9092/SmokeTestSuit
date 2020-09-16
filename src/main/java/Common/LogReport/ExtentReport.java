package Common.LogReport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;
public class ExtentReport {

    public static ExtentReports report= new ExtentReports("/Users/mohammed/Desktop/iMohammed/EmpCountDep_V1.0/TestingResult/Result.html",true);


    public static ExtentTest logger;
    public static String expected;
    public static String actual;
    public static ExtentTest getLogger() {
        return logger;
    }
    public void setLogger(ExtentTest logger) {
        this.logger = logger;
    }
    WebDriver driver ;
    public WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public ExtentReports getReport() {
        return report;
    }
    public void setReport(ExtentReports report) {
        this.report = report;
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Fail");
        }
    }

    @AfterSuite
    public void tearDown(){

        report.flush();
    }
}
