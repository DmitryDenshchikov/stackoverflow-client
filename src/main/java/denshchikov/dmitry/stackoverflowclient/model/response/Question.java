package denshchikov.dmitry.stackoverflowclient.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import denshchikov.dmitry.stackoverflowclient.deserializer.LocalDateTimeFromEpochDeserializer;

import java.time.LocalDateTime;
import java.util.List;

public record Question(
        @JsonProperty("accepted_answer_id") Integer acceptedAnswerId,

        @JsonProperty("answer_count") Integer answerCount,

        @JsonProperty("body_markdown") String bodyMarkdown,

        @JsonProperty("bounty_amount") Integer bountyAmount,

        @JsonProperty("close_vote_count") Integer closeVoteCount,

        @JsonProperty("closed_date")
        @JsonDeserialize(using = LocalDateTimeFromEpochDeserializer.class)
        LocalDateTime closedDate,

        @JsonProperty("closed_reason") String closedReason,

        @JsonProperty("comment_count") Integer commentCount,

        @JsonProperty("creation_date")
        @JsonDeserialize(using = LocalDateTimeFromEpochDeserializer.class)
        LocalDateTime creationDate,

        @JsonProperty("delete_vote_count") Integer deleteVoteCount,

        @JsonProperty("down_vote_count") Integer downVoteCount,

        @JsonProperty("is_answered") Boolean isAnswered,

        @JsonProperty("last_activity_date")
        @JsonDeserialize(using = LocalDateTimeFromEpochDeserializer.class)
        LocalDateTime lastActivityDate,

        @JsonProperty("last_edit_date")
        @JsonDeserialize(using = LocalDateTimeFromEpochDeserializer.class)
        LocalDateTime lastEditDate,

        @JsonProperty("last_editor") ShallowUser lastEditor,

        @JsonProperty String link,

        @JsonProperty ShallowUser owner,

        @JsonProperty("question_id") Integer questionId,

        @JsonProperty Integer score,

        @JsonProperty("share_link") String shareLink,

        @JsonProperty List<String> tags,

        @JsonProperty String title,

        @JsonProperty("up_vote_count") Integer upVoteCount,

        @JsonProperty("view_count") Integer viewCount
) {
}