package runners.runnerApi;

import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeTags("Api")
@IncludeEngines("cucumber")
@SelectClasspathResource("api")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdef.api, hooks.api")
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "json:build/reports/test/apiTest.json," + // generate report json version
                "html:build/reports/test/apiTest.html," + // report html version
                " html:build/reports/test/cucumberApiTest.html") // report html cucumber version


public class RunnerTestApi {
}
