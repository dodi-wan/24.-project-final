package runners.runnerWeb;


import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;



@Suite
@IncludeTags("web")
@SelectClasspathResource("web")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdef.web, hooks.web")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/web-report.html")

public class RunnerTestWeb {

}
