package cucumber.training_type;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gymcrm.gym_crm_spring.domain.TrainingType;
import com.gymcrm.gym_crm_spring.dto.TrainingTypeResponse;
import com.gymcrm.gym_crm_spring.service.TrainingTypeService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TrainingTypeSteps {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired
    private TrainingTypeService trainingTypeService;

    private ResultActions latestResponse;

    @Given("the system has the following training types:")
    public void systemHasTrainingTypes(DataTable dataTable) {
        List<String> expectedTypes = dataTable.asList().subList(1, dataTable.asList().size());;

        var existingTypes = trainingTypeService.findAll().stream()
                .map(TrainingType::getTrainingTypeName)
                .toList();

        assertTrue(existingTypes.containsAll(expectedTypes),
                "Database is missing expected training types from migrations.");
    }

    @When("I request all training types")
    public void iRequestAllTrainingTypes() throws Exception {
        latestResponse = mockMvc.perform(get("/api/training-types"));
    }

    @Then("the training types response status should be {int}")
    public void verifyStatus(int statusCode) throws Exception {
        latestResponse.andExpect(status().is(statusCode));
    }

    @Then("the response should contain the following training types:")
    public void verifyResponseContent(List<String> expectedNames) throws Exception {
        String content = latestResponse.andReturn().getResponse().getContentAsString();
        List<TrainingTypeResponse> actualTypes = objectMapper.readValue(
                content,
                new TypeReference<>() {}
        );

        List<String> actualNames = actualTypes.stream()
                .map(TrainingTypeResponse::trainingTypeName)
                .toList();

        assertTrue(actualNames.containsAll(expectedNames),
                "The API response did not contain all expected training types.");
    }
}
