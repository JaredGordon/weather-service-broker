package io.pivotal.ecosystem.simple;

import org.springframework.cloud.servicebroker.model.BrokerApiVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"io.pivotal.ecosystem.servicebroker", "io.pivotal.cf.servicebroker", "io.pivotal.ecosystem.simple"})
public class WeatherConfig {

    @Bean
    public BrokerApiVersion brokerApiVersion() {
        return new BrokerApiVersion();
    }

    @Bean
    String weatherHost(Environment env) {
        return env.getProperty("WEATHER_HOST");
    }

    @Bean
    String weatherPort(Environment env) {
        return env.getProperty("WEATHER_PORT");
    }
}