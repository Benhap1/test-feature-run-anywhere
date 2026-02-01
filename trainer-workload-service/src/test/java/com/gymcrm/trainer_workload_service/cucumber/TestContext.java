package com.gymcrm.trainer_workload_service.cucumber;

import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.ResultActions;

@Component
@ScenarioScope
public class TestContext {
    private ResultActions latestResponse;

    public void setResponse(ResultActions response) { this.latestResponse = response; }
    public ResultActions getResponse() { return latestResponse; }
}
