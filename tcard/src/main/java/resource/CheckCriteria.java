package resource;

public interface CheckCriteria<T> {
    boolean evaluate(User user, T object);
}
