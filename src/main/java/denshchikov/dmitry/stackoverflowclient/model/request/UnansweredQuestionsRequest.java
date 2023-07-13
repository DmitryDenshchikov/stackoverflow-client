package denshchikov.dmitry.stackoverflowclient.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UnansweredQuestionsRequest(@NotBlank String topic, @NotNull Integer page) {
}
