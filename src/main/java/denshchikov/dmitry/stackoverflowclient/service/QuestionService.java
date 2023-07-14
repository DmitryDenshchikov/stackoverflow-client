package denshchikov.dmitry.stackoverflowclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import denshchikov.dmitry.stackoverflowclient.config.StackExchangeApiProperties;
import denshchikov.dmitry.stackoverflowclient.model.stackexchange.response.QuestionCollection;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class QuestionService {

    private final HttpClient httpClient;
    private final StackExchangeApiProperties stackExchangeApiProperties;
    private final ObjectMapper om;


    public QuestionCollection getUnansweredQuestions(Integer page, Collection<String> topic) {
        try {
            var tags = String.join(";", topic);

            var uri = new URIBuilder()
                    .setScheme(URIScheme.HTTPS.toString())
                    .setHost(stackExchangeApiProperties.host())
                    .appendPath(stackExchangeApiProperties.version())
                    .appendPath("/questions/no-answers")
                    .addParameter("pagesize", "5")
                    .addParameter("page", String.valueOf(page))
                    .addParameter("order", "desc")
                    .addParameter("sort", "activity")
                    .addParameter("tagged", tags)
                    .addParameter("site", "stackoverflow")
                    .build();

            var response = httpClient.execute(
                    new HttpGet(uri),
                    new BasicHttpClientResponseHandler()
            );

            return om.readValue(response, QuestionCollection.class);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
