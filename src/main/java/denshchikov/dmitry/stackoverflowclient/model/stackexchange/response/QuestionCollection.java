package denshchikov.dmitry.stackoverflowclient.model.stackexchange.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public final class QuestionCollection extends ItemCollection<Question> {


    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public QuestionCollection(@JsonProperty("items") Collection<Question> items,
                              @JsonProperty("has_more") boolean hasMore,
                              @JsonProperty("quota_max") Integer quotaMax,
                              @JsonProperty("quota_remaining") Integer quotaRemaining) {
        super(items, hasMore, quotaMax, quotaRemaining);

    }

}
