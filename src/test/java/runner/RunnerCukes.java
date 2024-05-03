package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.EXECUTION_DRY_RUN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
//@ConfigurationParameter(key="cucumber.filter.tags", value="@Run2")
@ConfigurationParameter(key="cucumber.publish.quiet", value="true")
//@ConfigurationParameter(key="cucumber.dry", value="true")
//@ConfigurationParameter(key=EXECUTION_DRY_RUN_PROPERTY_NAME, value="true")

public class RunnerCukes {

}