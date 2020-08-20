package com.telstra.b2b.dig.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        glue = "com.telstra.b2b.dig.steps",
        features = "src\\test\\resources\\cucumber",        
       plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
        
        
)
// Test Comment
public class RunCalculatorTest {

@AfterClass
public static void teardown() {
	
	com.cucumber.listener.Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	com.cucumber.listener.Reporter.setSystemInfo("user", System.getProperty("user.name"));	
	com.cucumber.listener.Reporter.setTestRunnerOutput("Sample test runner output message");
}

@BeforeClass
public static void setup() {
    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
    extentProperties.setReportPath(System.getProperty("user.dir") +"/test-output/SampleExtentReport.html");
	}
}
