package denshchikov.dmitry.stackoverflowclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties("app.stackexchange.api")
public record StackExchangeApiProperties(String host,
                                         String version) {

    @ConstructorBinding
    public StackExchangeApiProperties {
    }

}