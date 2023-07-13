package denshchikov.dmitry.stackoverflowclient.model.stackexchange.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public sealed class ItemCollection<T> permits QuestionCollection {

    private final Collection<T> items;
    private final boolean hasMore;
    private final Integer quotaMax;
    private final Integer quotaRemaining;

}
