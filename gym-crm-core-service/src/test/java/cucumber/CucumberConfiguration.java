package cucumber;

import com.gymcrm.gym_crm_spring.GymCrmSpringApplication;
import cucumber.config.TestConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest(
        classes = {GymCrmSpringApplication.class, TestConfig.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration.class,
        org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration.class
})
@ComponentScan(basePackages = "cucumber")
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CucumberConfiguration {

}
