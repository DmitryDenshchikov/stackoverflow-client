package denshchikov.dmitry.stackoverflowclient.handler;

import denshchikov.dmitry.stackoverflowclient.service.QuestionService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class QuestionHandler {

    private final QuestionService questionService;


    public QuestionHandler(QuestionService questionService) {
        this.questionService = questionService;
    }


    public ServerResponse getQuestions(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(questionService.getQuestions());
    }


}