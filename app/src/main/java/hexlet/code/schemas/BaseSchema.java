package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected final List<Predicate<T>> checks = new ArrayList<>();

    public boolean isValid(T validatedString) {
        return checks.stream()
            .allMatch(sp -> sp.test(validatedString));
    }
}
