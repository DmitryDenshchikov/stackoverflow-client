package denshchikov.dmitry.stackoverflowclient.router;

import denshchikov.dmitry.stackoverflowclient.handler.QuestionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class QuestionRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> getQuestions(QuestionHandler questionHandler) {

        return RouterFunctions
                .route(GET("/questions").and(accept(MediaType.APPLICATION_JSON)), questionHandler::getQuestions);
    }

}

