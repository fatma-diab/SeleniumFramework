package runner;

import Tests.TestBase;
import cucumber.api.CucumberOptions;

	@CucumberOptions(features = "src//test//java//Features"
			,glue= {"steps"}
	,plugin= {"pretty","html:target/cucumber-html-report"})
	public class TestRunner extends TestBase
	{


	}

