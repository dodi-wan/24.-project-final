package runners.runnerApi;

import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeTags("Api")
@IncludeEngines("cucumber")
@SelectClasspathResource("api")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdef.api, hooks.api")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:target/api-report.json")


public class RunnerTestApi {
}
