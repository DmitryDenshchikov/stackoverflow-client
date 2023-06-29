package denshchikov.dmitry.stackoverflowclient.controller;

import denshchikov.dmitry.stackoverflowclient.handler.QuestionHandler;
import denshchikov.dmitry.stackoverflowclient.model.request.UnansweredQuestionsRequest;
import denshchikov.dmitry.stackoverflowclient.model.stackexchange.response.QuestionCollection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionHandler questionHandler;


    @GetMapping(path = "/questions/unanswered",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionCollection getQuestions(UnansweredQuestionsRequest req) {
        return questionHandler.getQuestions(req);
    }

}
