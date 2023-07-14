package denshchikov.dmitry.stackoverflowclient.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;

public record UnansweredQuestionsRequest(@NotEmpty Collection<String> topic, @NotNull Integer page) {
}
