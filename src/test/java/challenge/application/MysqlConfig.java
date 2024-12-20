package challenge.application;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;


@TestConfiguration(proxyBeanMethods = false)
public class MysqlConfig {
    @Bean
    @ServiceConnection
    MySQLContainer<?> mySQLContainer(){
        return new MySQLContainer<>("mysql:8.0").withDatabaseName("challenge")
                .withUsername("root").withPassword("fishKekse").withExposedPorts(3306)
                .withInitScript(
                        "test.sql");
    }



}
