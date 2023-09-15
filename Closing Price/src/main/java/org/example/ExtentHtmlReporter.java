package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportExample {
    public static void main(String[] args) {
        // Initialize ExtentHtmlReporter and ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/extent-report.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Create a test in the report
        ExtentTest test = extent.createTest("Sample Test", "This is a sample Extent Report test.");

        // Add test steps
        test.info("This is an informational step.");
        test.pass("This step passed.");
        test.fail("This step failed.");

        // Flush the report to save it
        extent.flush();
    }
}