package denshchikov.dmitry.stackoverflowclient.model.response;

import java.util.Collection;
import java.util.Objects;

public sealed class ItemCollection<T> permits QuestionCollection {

    private final Collection<T> items;
    private final boolean hasMore;
    private final Integer quotaMax;
    private final Integer quotaRemaining;


    public ItemCollection(Collection<T> items, boolean hasMore, Integer quotaMax, Integer quotaRemaining) {
        this.items = items;
        this.hasMore = hasMore;
        this.quotaMax = quotaMax;
        this.quotaRemaining = quotaRemaining;
    }

    public Collection<T> getItems() {
        return items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ItemCollection) obj;
        return Objects.equals(this.items, that.items) &&
                this.hasMore == that.hasMore &&
                Objects.equals(this.quotaMax, that.quotaMax) &&
                Objects.equals(this.quotaRemaining, that.quotaRemaining);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, hasMore, quotaMax, quotaRemaining);
    }

    @Override
    public String toString() {
        return "ItemCollection[" +
                "items=" + items + ", " +
                "hasMore=" + hasMore + ", " +
                "quotaMax=" + quotaMax + ", " +
                "quotaRemaining=" + quotaRemaining + ']';
    }

}
