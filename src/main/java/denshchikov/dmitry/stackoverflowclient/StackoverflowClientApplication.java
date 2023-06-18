package denshchikov.dmitry.stackoverflowclient;

import denshchikov.dmitry.stackoverflowclient.config.StackExchangeApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(StackExchangeApiProperties.class)
@SpringBootApplication
public class StackoverflowClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackoverflowClientApplication.class, args);
	}

}
