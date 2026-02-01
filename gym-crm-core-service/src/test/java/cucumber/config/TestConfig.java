package cucumber.config;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

/**
 * Test configuration for component tests.
 * 
 * Note: Testcontainers is disabled due to Docker Desktop connectivity issues on Windows.
 * Tests use the existing PostgreSQL container from docker-compose (port 5439).
 * 
 * To enable Testcontainers in the future (when Docker Desktop connectivity is fixed):
 * 1. Uncomment the postgresContainer() method below
 * 2. Add @ServiceConnection annotation
 * 3. Remove the datasource URL from application-test.properties
 */
@TestConfiguration(proxyBeanMethods = false)
public class TestConfig {
    
    // Testcontainers PostgreSQL configuration - DISABLED due to Docker connectivity issues
    // Uncomment when Docker Desktop connectivity is working:
    /*
    @Bean
    @ServiceConnection
    public PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:15"))
                .withDatabaseName("gymcrm_test")
                .withUsername("postgres")
                .withPassword("postgres");
    }
    */

    @Bean
    public JmsTemplate jmsTemplate() {
        return Mockito.mock(JmsTemplate.class);
    }
}
