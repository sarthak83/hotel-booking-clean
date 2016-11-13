package com.capgemini.interview.hotelbooking;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",
				 tags = {"@test2"},
				 plugin = {"pretty",
						 	"html:target/test-report",
						 	"json:target/test-report.json",
						 	"junit:target/test-report.xml"}
				)

public class RunCucumberTest {
	
}
