package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected final List<Predicate> checks = new ArrayList<>();

    public final boolean isValid(Object validatedString) {
        return checks.stream()
            .allMatch(sp -> sp.test(validatedString));
    }
}
