package com.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		plugin= {// report
				"html:target/report/cucumber.html",
				"json:target/cucumber.json"
				
		},
		
		features = {"src/test/resources/orbisLogin.feature"},//path	
		glue = {"com.cucumber.stedef"}//stepdef package name		
         )

	public class RunnerFile extends AbstractTestNGCucumberTests {
	
}

