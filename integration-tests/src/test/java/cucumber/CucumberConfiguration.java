package cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest(
        classes = CucumberConfiguration.TestConfig.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CucumberConfiguration {

    @Configuration
    @SpringBootApplication
    public static class TestConfig {}

    @PostConstruct
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
