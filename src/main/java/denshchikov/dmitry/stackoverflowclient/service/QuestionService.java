package denshchikov.dmitry.stackoverflowclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import denshchikov.dmitry.stackoverflowclient.config.StackExchangeApiProperties;
import denshchikov.dmitry.stackoverflowclient.model.response.QuestionCollection;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class QuestionService {

    private final HttpClient httpClient;
    private final StackExchangeApiProperties stackExchangeApiProperties;
    private final ObjectMapper om;


    public QuestionService(HttpClient httpClient,
                           StackExchangeApiProperties stackExchangeApiProperties,
                           ObjectMapper om) {
        this.httpClient = httpClient;
        this.stackExchangeApiProperties = stackExchangeApiProperties;
        this.om = om;
    }


    public QuestionCollection getQuestions() {
        try {
            URI uri = new URIBuilder()
                    .setScheme(URIScheme.HTTPS.toString())
                    .setHost(stackExchangeApiProperties.host())
                    .appendPath(stackExchangeApiProperties.version())
                    .appendPath("/questions")
                    .addParameter("pagesize", "2")
                    .addParameter("order", "desc")
                    .addParameter("sort", "activity")
                    .addParameter("site", "stackoverflow")
                    .build();

            String response = httpClient.execute(
                    new HttpGet(uri),
                    new BasicHttpClientResponseHandler()
            );

            QuestionCollection questionCollection = om.readValue(response, QuestionCollection.class);

            return questionCollection;
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
