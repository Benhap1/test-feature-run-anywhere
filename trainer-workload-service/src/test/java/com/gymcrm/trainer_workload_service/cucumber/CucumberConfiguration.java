package com.gymcrm.trainer_workload_service.cucumber;

import com.gymcrm.trainer_workload_service.TrainerWorkloadServiceApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest(
        classes = {TrainerWorkloadServiceApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration.class,
        org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration.class
})
@ComponentScan(basePackages = "cucumber")
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CucumberConfiguration {
    @MockBean
    private org.springframework.jms.core.JmsTemplate jmsTemplate;

    @MockBean
    private com.gymcrm.trainer_workload_service.messaging.WorkloadMessageConsumer workloadMessageConsumer;
}
