package denshchikov.dmitry.stackoverflowclient.handler;

import denshchikov.dmitry.stackoverflowclient.model.request.UnansweredQuestionsRequest;
import denshchikov.dmitry.stackoverflowclient.model.stackexchange.response.QuestionCollection;
import denshchikov.dmitry.stackoverflowclient.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionHandler {

    private final QuestionService questionService;


    public QuestionCollection getQuestions(UnansweredQuestionsRequest req) {
        return questionService.getUnansweredQuestions(req.page(), req.topic());
    }


}