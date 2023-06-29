package denshchikov.dmitry.stackoverflowclient.model.stackexchange.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ShallowUser(
        @JsonProperty("account_id") int accountId,
        @JsonProperty("display_name") String displayName,
        String link,
        Integer reputation,
        @JsonProperty("user_id") Integer userId) {
}
